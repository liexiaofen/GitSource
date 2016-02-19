package com.lw.oa.common.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.commons.lang.StringUtils;
/**
 * *@author yuliang
 */
public class StringUtil {

	public static final String WHITESPACE = " \n\r\f\t";

	public static String padString(String srcString, int length,
			String padString, boolean leftPad) {
		int padLength = length - srcString.length();
		if (padLength > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i <= padLength / padString.length(); i++)
				sb.append(padString);

			sb.append(padString.substring(0, padLength % padString.length()));
			if (leftPad)
				return sb.toString() + srcString;
			else
				return srcString + sb.toString();
		} else {
			return srcString.substring(0, length);
		}
	}

	public static String replaceString(String str, String oldStr, String newStr) {
		String strRest = "";
		String strTemp = new String(str);
		int index = str.indexOf(oldStr);
		if (index < 0)
			return str;
		int len = oldStr.length();
		do {
			if (index < 0)
				break;
			if (index > 0)
				strRest = strRest + strTemp.substring(0, index) + newStr;
			else if (index == 0)
				strRest = strRest + newStr;
			if (index + len < strTemp.length()) {
				strTemp = strTemp.substring(index + len);
			} else {
				strTemp = "";
				break;
			}
			index = strTemp.indexOf(oldStr);
		} while (true);
		strRest = strRest + strTemp;
		return strRest;
	}

	public static int lastIndexOfLetter(String string) {
		for (int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			if (!Character.isLetter(character) /* && !('_'==character) */)
				return i - 1;
		}
		return string.length() - 1;
	}

	public static String join(String seperator, String[] strings) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuffer buf = new StringBuffer(length * strings[0].length())
				.append(strings[0]);
		for (int i = 1; i < length; i++) {
			buf.append(seperator).append(strings[i]);
		}
		return buf.toString();
	}

	public static boolean equals(String str1, String str2) {
		return str1 != null ? str1.equals(str2) : str2 == null;
	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 != null ? str1.equalsIgnoreCase(str2) : str2 == null;
	}

	public static int indexOf(String str, char searchChar) {
		if (str == null || str.length() == 0)
			return -1;
		else
			return str.indexOf(searchChar);
	}

	public static int indexOf(String str, char searchChar, int startPos) {
		if (str == null || str.length() == 0)
			return -1;
		else
			return str.indexOf(searchChar, startPos);
	}

	public static int indexOf(String str, String searchStr) {
		if (str == null || searchStr == null)
			return -1;
		else
			return str.indexOf(searchStr);
	}

	public static int indexOf(String str, String searchStr, int startPos) {
		if (str == null || searchStr == null)
			return -1;
		if (searchStr.length() == 0 && startPos >= str.length())
			return str.length();
		else
			return str.indexOf(searchStr, startPos);
	}

	public static int lastIndexOf(String str, char searchChar) {
		if (str == null || str.length() == 0)
			return -1;
		else
			return str.lastIndexOf(searchChar);
	}

	public static int lastIndexOf(String str, char searchChar, int startPos) {
		if (str == null || str.length() == 0)
			return -1;
		else
			return str.lastIndexOf(searchChar, startPos);
	}

	public static int lastIndexOf(String str, String searchStr) {
		if (str == null || searchStr == null)
			return -1;
		else
			return str.lastIndexOf(searchStr);
	}

	public static int lastIndexOf(String str, String searchStr, int startPos) {
		if (str == null || searchStr == null)
			return -1;
		else
			return str.lastIndexOf(searchStr, startPos);
	}

	public static boolean contains(String str, char searchChar) {
		if (str == null || str.length() == 0)
			return false;
		else
			return str.indexOf(searchChar) >= 0;
	}

	public static boolean contains(String str, String searchStr) {
		if (str == null || searchStr == null)
			return false;
		else
			return str.indexOf(searchStr) >= 0;
	}

	public static int indexOfAny(String str, char searchChars[]) {
		if (str == null || str.length() == 0 || searchChars == null
				|| searchChars.length == 0)
			return -1;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for (int j = 0; j < searchChars.length; j++)
				if (searchChars[j] == ch)
					return i;
		}
		return -1;
	}

	public static int indexOfAny(String str, String searchChars) {
		if (str == null || str.length() == 0 || searchChars == null
				|| searchChars.length() == 0)
			return -1;
		else
			return indexOfAny(str, searchChars.toCharArray());
	}

	public static String join(String seperator, @SuppressWarnings("rawtypes") Iterator objects) {
		StringBuffer buf = new StringBuffer();
		if (objects.hasNext())
			buf.append(objects.next());
		while (objects.hasNext()) {
			buf.append(seperator).append(objects.next());
		}
		return buf.toString();
	}

	public static String[] add(String[] x, String sep, String[] y) {
		String[] result = new String[x.length];
		for (int i = 0; i < x.length; i++) {
			result[i] = x[i] + sep + y[i];
		}
		return result;
	}

	public static String repeat(String string, int times) {
		StringBuffer buf = new StringBuffer(string.length() * times);
		for (int i = 0; i < times; i++)
			buf.append(string);
		return buf.toString();
	}

	public static String replace(String template, String placeholder,
			String replacement) {
		return replace(template, placeholder, replacement, false);
	}

	public static String[] replace(String templates[], String placeholder,
			String replacement) {
		String[] result = new String[templates.length];
		for (int i = 0; i < templates.length; i++) {
			result[i] = replace(templates[i], placeholder, replacement);
			;
		}
		return result;
	}

	public static String replace(String template, String placeholder,
			String replacement, boolean wholeWords) {
		int loc = template == null ? -1 : template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			final boolean actuallyReplace = !wholeWords
					|| loc + placeholder.length() == template.length()
					|| !Character.isJavaIdentifierPart(template.charAt(loc
							+ placeholder.length()));
			String actualReplacement = actuallyReplace ? replacement
					: placeholder;
			return new StringBuffer(template.substring(0, loc))
					.append(actualReplacement)
					.append(replace(
							template.substring(loc + placeholder.length()),
							placeholder, replacement, wholeWords)).toString();
		}
	}

	public static String replaceOnce(String template, String placeholder,
			String replacement) {
		int loc = template == null ? -1 : template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			return new StringBuffer(template.substring(0, loc))
					.append(replacement)
					.append(template.substring(loc + placeholder.length()))
					.toString();
		}
	}

	public static String[] split(String seperators, String list) {
		return split(seperators, list, false);
	}

	public static String[] split(String seperators, String list, boolean include) {
		StringTokenizer tokens = new StringTokenizer(list, seperators, include);
		String[] result = new String[tokens.countTokens()];
		int i = 0;
		while (tokens.hasMoreTokens()) {
			result[i++] = tokens.nextToken();
		}
		return result;
	}

	public static String unqualify(String qualifiedName) {
		int loc = qualifiedName.lastIndexOf(".");
		return (loc < 0) ? qualifiedName : qualifiedName
				.substring(qualifiedName.lastIndexOf(".") + 1);
	}

	public static String qualifier(String qualifiedName) {
		int loc = qualifiedName.lastIndexOf(".");
		return (loc < 0) ? "" : qualifiedName.substring(0, loc);
	}

	public static String[] suffix(String[] columns, String suffix) {
		if (suffix == null)
			return columns;
		String[] qualified = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			qualified[i] = suffix(columns[i], suffix);
		}
		return qualified;
	}

	private static String suffix(String name, String suffix) {
		return (suffix == null) ? name : name + suffix;
	}

	public static String root(String qualifiedName) {
		int loc = qualifiedName.indexOf(".");
		return (loc < 0) ? qualifiedName : qualifiedName.substring(0, loc);
	}

	public static String unroot(String qualifiedName) {
		int loc = qualifiedName.indexOf(".");
		return (loc < 0) ? qualifiedName : qualifiedName.substring(loc + 1,
				qualifiedName.length());
	}

	public static boolean booleanValue(String tfString) {
		String trimmed = tfString.trim().toLowerCase();
		return trimmed.equals("true") || trimmed.equals("t");
	}

	public static String toString(Object[] array) {
		int len = array.length;
		if (len == 0)
			return "";
		StringBuffer buf = new StringBuffer(len * 12);
		for (int i = 0; i < len - 1; i++) {
			buf.append(array[i]).append(", ");
		}
		return buf.append(array[len - 1]).toString();
	}

	public static String[] multiply(String string, @SuppressWarnings("rawtypes") Iterator placeholders,
			@SuppressWarnings("rawtypes") Iterator replacements) {
		String[] result = new String[] { string };
		while (placeholders.hasNext()) {
			result = multiply(result, (String) placeholders.next(),
					(String[]) replacements.next());
		}
		return result;
	}

	private static String[] multiply(String[] strings, String placeholder,
			String[] replacements) {
		String[] results = new String[replacements.length * strings.length];
		int n = 0;
		for (int i = 0; i < replacements.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				results[n++] = replaceOnce(strings[j], placeholder,
						replacements[i]);
			}
		}
		return results;
	}

	public static int countUnquoted(String string, char character) {
		if ('\'' == character) {
			throw new IllegalArgumentException(
					"Unquoted count of quotes is invalid");
		}
		if (string == null)
			return 0;
		int count = 0;
		int stringLength = string.length();
		boolean inQuote = false;
		for (int indx = 0; indx < stringLength; indx++) {
			char c = string.charAt(indx);
			if (inQuote) {
				if ('\'' == c) {
					inQuote = false;
				}
			} else if ('\'' == c) {
				inQuote = true;
			} else if (c == character) {
				count++;
			}
		}
		return count;
	}

	public static boolean isNotEmpty(String string) {
		return string != null && string.length() > 0;
	}

	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}

	public static String qualify(String prefix, String name) {
		if (name == null || prefix == null) {
			throw new NullPointerException();
		}
		return new StringBuffer(prefix.length() + name.length() + 1)
				.append(prefix).append('.').append(name).toString();
	}

	public static String[] qualify(String prefix, String[] names) {
		if (prefix == null)
			return names;
		int len = names.length;
		String[] qualified = new String[len];
		for (int i = 0; i < len; i++) {
			qualified[i] = qualify(prefix, names[i]);
		}
		return qualified;
	}

	public static int firstIndexOfChar(String sqlString, String string,
			int startindex) {
		int matchAt = -1;
		for (int i = 0; i < string.length(); i++) {
			int curMatch = sqlString.indexOf(string.charAt(i), startindex);
			if (curMatch >= 0) {
				if (matchAt == -1) { // first time we find match!
					matchAt = curMatch;
				} else {
					matchAt = Math.min(matchAt, curMatch);
				}
			}
		}
		return matchAt;
	}

	public static String truncate(String string, int length) {
		if (string.length() <= length) {
			return string;
		} else {
			return string.substring(0, length);
		}
	}

	public static String unqualifyEntityName(String entityName) {
		String result = unqualify(entityName);
		int slashPos = result.indexOf('/');
		if (slashPos > 0) {
			result = result.substring(0, slashPos - 1);
		}
		return result;
	}

	public static String toUpperCase(String str) {
		return str == null ? null : str.toUpperCase();
	}

	public static String toLowerCase(String str) {
		return str == null ? null : str.toLowerCase();
	}

	public static String moveAndToBeginning(String filter) {
		if (filter.trim().length() > 0) {
			filter += " and ";
			if (filter.startsWith(" and "))
				filter = filter.substring(4);
		}
		return filter;
	}

	public static String left(String str, int len) {
		if (str == null)
			return null;
		if (len < 0)
			return "";
		if (str.length() <= len)
			return str;
		else
			return str.substring(0, len);
	}

	public static String right(String str, int len) {
		if (str == null)
			return null;
		if (len < 0)
			return "";
		if (str.length() <= len)
			return str;
		else
			return str.substring(str.length() - len);
	}

	public static String mid(String str, int pos, int len) {
		if (str == null)
			return null;
		if (len < 0 || pos > str.length())
			return "";
		if (pos < 0)
			pos = 0;
		if (str.length() <= pos + len)
			return str.substring(pos);
		else
			return str.substring(pos, pos + len);
	}

	public static boolean isBlank(String value) {
		return StringUtils.isBlank(value);
	}

	public static String rightPad(String originalText, String padString,
			int destLength) {
		if (originalText == null)
			return originalText;
		if (originalText.length() >= destLength)
			return originalText;
		int originalLength = originalText.length();
		int padLength = destLength - originalLength;
		if (padString == null)
			padString = " ";
		StringBuffer result = new StringBuffer();
		result.append(originalText);
		for (int i = 0; i < padLength; ++i) {
			int j = i % padString.length();
			result.append(padString.charAt(j));
		}
		return result.toString();
	}

	public static String leftPad(String originalText, String padString,
			int destLength) {
		if (originalText == null)
			return originalText;
		StringBuffer result = new StringBuffer();
		result.append(rightPad("", padString,
				destLength - originalText.length()));

		result.append(originalText);
		return result.toString();
	}

	public static String collectionToString(Object object, String joinString) {
		if (object == null)
			return null;
		if (joinString == null)
			joinString = ",";
		StringBuffer result = new StringBuffer();
		boolean isFirst = true;
		if (object instanceof Collection) {
			@SuppressWarnings("rawtypes")
			Collection collection = (Collection) object;
			for (@SuppressWarnings("rawtypes")
			Iterator it = collection.iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj != null) {
					if (!(isFirst))
						result.append(joinString);

					result.append(obj.toString());
					isFirst = false;
				}
			}
			return result.toString();
		}
		if (object.getClass().isArray()) {
			int length = Array.getLength(object);
			for (int i = 0; i < length; ++i) {
				Object element = Array.get(object, i);
				if (element != null) {
					if (!(isFirst))
						result.append(joinString);

					result.append(element.toString());
					isFirst = false;
				}
			}
			return result.toString();
		}
		throw new RuntimeException("对象类型" + object.getClass().getName()
				+ "不是集合或数组");
	}

	public static String concat(String joinString, String[] strings) {
		if (strings == null)
			return null;
		if (joinString == null)
			joinString = "";

		int length = strings.length;
		StringBuffer result = new StringBuffer();
		boolean flag = false;
		for (int i = 0; i < length; ++i) {
			if (strings[i] == null)
				break;

			if (flag == true)
				result.append(joinString);

			result.append(strings[i]);
			flag = true;
		}
		return result.toString();
	}

	public static boolean isDouble(String text) {
		try {
			new Double(text);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static String replaceParms(String value, String[] parms) {
		String rt = value;
		for (int i = 0; i < parms.length; i++) {
			if (null == parms[i])
				break;
			rt = rt.replaceAll("[{]" + i + "[}]",
					parms[i].replaceAll("\\\\", "\\\\\\\\"));
		}
		return rt;
	}

	public static String getNullString(Object value) {
		if (value == null) {
			return "";
		} else {
			return value.toString();
		}

	}

	public static boolean isNullString(Object value) {
		if (value == null) {
			return true;
		}

		if ("".equals(((String) value).trim())) {
			return true;
		}

		return false;
	}

}
