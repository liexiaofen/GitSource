package org.oms.qiye.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.oms.qiye.pojo.resp.TextMessage;
import org.oms.qiye.util.MessageUtil;
import org.springframework.web.context.ContextLoader;
import com.winsolution.weixin.entity.TPostmpEntity;
import com.winsolution.weixin.entity.TempSignEntity;
import com.winsolution.weixin.service.ITPosTmpService;
import com.winsolution.weixin.service.ITempSignService;

/**
 * 处理微信发来的信息
 * @author Winsolution
 *
 */
public class CoreService {
	
	public static String processRequest(String msg) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			//String respContent = "欢迎进入Winsolution考勤系统！";
			String respContent = "";
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(msg);

			//System.out.println("Event=="+requestMap.get("Event"));
			
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			//消息时间
			String createTime = requestMap.get("CreateTime");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			long l = new Long(createTime).longValue() * 1000;
			Date date = new Date(l);
			String dt = sdf.format(date);
			
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String content = requestMap.get("Content"); 
				respContent = "Winsolution提示：您发送的是文本消息！内容是："+content;
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "Winsolution提示：您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "Winsolution提示：您发送的是地理位置消息！"; 
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "Winsolution提示：您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "Winsolution提示：您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				//进入事件 考勤管理
				if(MessageUtil.REQ_MESSAGE_TYPE_EVENT_AGENT.equalsIgnoreCase(eventType))
				{
					respContent = "欢迎进入Winsolution考勤系统！";
				}
				//获取地理位置
				else if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equalsIgnoreCase(eventType))
				{
					//插入纬度 经度  精度
					ITPosTmpService tPostmpService = (ITPosTmpService)ContextLoader.getCurrentWebApplicationContext().getBean("tPostmpService");
					TPostmpEntity tPostmpEntity = new TPostmpEntity();
					tPostmpEntity.setAppid(Integer.parseInt(requestMap.get("AgentID")));
					tPostmpEntity.setUid(requestMap.get("FromUserName"));
					tPostmpEntity.setCreateTime(requestMap.get("CreateTime").concat("000"));
					tPostmpEntity.setLatitude(Float.parseFloat(requestMap.get("Latitude")));
					tPostmpEntity.setLongitude(Float.parseFloat(requestMap.get("Longitude")));
					tPostmpEntity.setPrec(Float.parseFloat(requestMap.get("Precision")));
					tPostmpService.insertTPosTmp(tPostmpEntity);
					
					respContent = "";
				}
				// 自定义菜单点击事件
				else if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");
                    
                    
                    ITempSignService tempSignService = (ITempSignService)ContextLoader.getCurrentWebApplicationContext().getBean("tempSignService");
                    TempSignEntity tempSignEntity = new TempSignEntity();
                    sdf = new SimpleDateFormat("yyyyMM");
                    //签到,签退数据库插入
                    if(MessageUtil.RESP_MESSAGE_TYPE_QD.equalsIgnoreCase(eventKey))
                    {//签到
                    	tempSignEntity.setUid(requestMap.get("FromUserName"));
                    	tempSignEntity.setMsgtime(requestMap.get("CreateTime").concat("000"));
                    	tempSignEntity.setSigntype("1");
                    	tempSignEntity.setEnt("event");
                    	tempSignEntity.setMsgfrom("1");
                    	tempSignEntity.setSignyyyymm(sdf.format(date));
                    	tempSignEntity.setSigndate(new java.sql.Date(date.getTime()));
                    	
                    	TPostmpEntity tpostmp=new TPostmpEntity();
                    	tpostmp.setUid(tempSignEntity.getUid());
                    	tpostmp.setCreateTime(tempSignEntity.getMsgtime());
                    	ITPosTmpService tPostmpService=(ITPosTmpService)ContextLoader.getCurrentWebApplicationContext().getBean("tPostmpService");
                    	int count=tPostmpService.getTPosTmpCountInFiveMinutes(tpostmp);
                    	if(count>0){
                    	tempSignService.insertTempSign(tempSignEntity);
                    	respContent = "Winsolution提示：用户名是"+fromUserName+"签到成功，签到时间："+dt;
                    	}else{
                    		respContent = "Winsolution提示：无法取得你的地理位置,请稍候重试";
                    	}
                    }else if(MessageUtil.RESP_MESSAGE_TYPE_QT.equalsIgnoreCase(eventKey))
                    {//签退
                    	tempSignEntity.setUid(requestMap.get("FromUserName"));
                    	tempSignEntity.setMsgtime(requestMap.get("CreateTime").concat("000"));
                    	tempSignEntity.setSigntype("2");
                    	tempSignEntity.setEnt("event");
                    	tempSignEntity.setMsgfrom("1");
                    	tempSignEntity.setSignyyyymm(sdf.format(date));
                    	tempSignEntity.setSigndate(new java.sql.Date(date.getTime()));
                    	
                    	TPostmpEntity tpostmp=new TPostmpEntity();
                    	tpostmp.setUid(tempSignEntity.getUid());
                    	tpostmp.setCreateTime(tempSignEntity.getMsgtime());
                    	ITPosTmpService tPostmpService=(ITPosTmpService)ContextLoader.getCurrentWebApplicationContext().getBean("tPostmpService");
                    	int count=tPostmpService.getTPosTmpCountInFiveMinutes(tpostmp);
                    	if(count>0){
                    	tempSignService.insertTempSign(tempSignEntity);
                    	respContent = "Winsolution提示：用户名是"+fromUserName+"签退成功，签退时间："+dt;
                    	}else{
                    		respContent = "Winsolution提示：无法取得你的地理位置,请稍候重试";
                    	}
                    }
                    
                    //System.out.println("EventKey="+eventKey);
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
			respMessage="有异常了。。。";
		}
		return respMessage;
	}

}
