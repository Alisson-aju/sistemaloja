package org.sisloja.une.gui.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class Constraints {
	
	public static void setTextFieldInteger(final TextField txt) {
		txt.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
			if (newValue != null && !newValue.matches("\\d*")) {
			txt.setText(oldValue);
			}
			}
		});
		}
		public static void setTextFieldMaxLength(final TextField txt, final int max) {
		txt.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
			if (newValue != null && newValue.length() > max) {
			txt.setText(oldValue);
			}
			}
		});
		}
		public static void setTextFieldDouble(final TextField txt) {
		txt.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
			txt.setText(oldValue);
			}
			}
		});
		}
}
