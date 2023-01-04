package sk.gravicon.siriuslib;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
/*

 * */

/**
 * @author gonczol
 * JavaFX textové pole pre desatinné čísla. V fxml súbore aj scenebuildery je možné nastaviť
 * mask napr. ####.##
 * Ako desatinná čiarka sa používa bodka,
 * Ako číslo je možné použiť ľubovoľný znak okrem bodky 
 */
public class DecimalTextField extends TextField {
	private StringProperty mask;

	public DecimalTextField() {
		init();
	}

	private void init() {
		// "\\d{0,3}([\\.\\,]\\d{0,2})?"
		mask = new SimpleStringProperty();
		this.textProperty().addListener((observable, oldValue, newValue) -> {
			String maskString = getMask();
			int wholePart = maskString.indexOf(".");
			int decimalPart = maskString.length() - wholePart-1;
			String expr = "\\d{0,"+String.valueOf(wholePart)+"}([\\.\\,]\\d{0,"+String.valueOf(decimalPart)+"})?";
			if (!newValue.matches(expr)) {
				this.setText(oldValue);
			}
		});

	}

	public String getMask() {
		return mask.get();
	}

	public void setMask(String mask) {
		this.mask.set(mask);

	}

	public StringProperty maskProperty() {
		return this.mask;
	}

}
