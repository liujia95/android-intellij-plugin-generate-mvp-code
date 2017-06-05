package me.liujia95;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Constants for various stuff used in whole plugin.
 * @author David Vávra (david@inmite.eu)
 */
public class Constants {
    public static final String NORMAL = "_normal";
	public static final String FOCUSED = "_focused";
	public static final String PRESSED = "_pressed";
	public static final String SELECTED = "_selected";
	public static final String CHECKED = "_checked";
	public static final String DISABLED = "_disabled";
	public static final String HOVERED = "_hovered";
	public static final String CHECKABLE = "_checkable";
	public static final String ACTIVATED = "_activated";
	public static final String WINDOW_FOCUSED = "_windowfocused";
	public static String[] SUFFIXES = new String[]{NORMAL, PRESSED, FOCUSED, SELECTED, CHECKED, DISABLED, HOVERED, CHECKABLE, ACTIVATED, WINDOW_FOCUSED};
	public static Pattern VALID_FOLDER_PATTERN = Pattern.compile("^drawable(-[a-zA-Z0-9]+)*$");
	public static String EXPORT_FOLDER = "drawable";
	public static HashMap<String, State> sMapping;

	static {
		// mapping from file suffixes into android attributes and their default values
		sMapping = new HashMap<String, State>();
		sMapping.put(FOCUSED, new State("state_focused", false));
		sMapping.put(PRESSED, new State("state_pressed", false));
		sMapping.put(SELECTED, new State("state_selected", false));
		sMapping.put(CHECKED, new State("state_checked", false));
		sMapping.put(DISABLED, new State("state_enabled", true));
		sMapping.put(HOVERED, new State("state_hovered", false));
		sMapping.put(CHECKABLE, new State("state_checkable", false));
		sMapping.put(ACTIVATED, new State("state_activated", false));
		sMapping.put(WINDOW_FOCUSED, new State("state_window_focused", false));
	}

	static class State {
		public String attributeName;
		public boolean defaultValue;

		State(String attributeName, boolean defaultValue) {
			this.attributeName = attributeName;
			this.defaultValue = defaultValue;
		}
	}

}