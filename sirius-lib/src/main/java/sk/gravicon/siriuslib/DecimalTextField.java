package sk.gravicon.siriuslib;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;


/**
 * JavaFX textové pole pre desatinné čísla. V fxml súbore aj scenebuildery je možné nastaviť
 * mask napr. ####.##
 * Ako desatinná čiarka sa používa bodka,alebo čiarka
 * Ako číslo je možné použiť ľubovoľný znak okrem bodky a čiarky
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
			int wholePart=-1;
			wholePart = maskString.indexOf(".");
			if(wholePart==-1) {
				wholePart = maskString.indexOf(",");
			}
			//System.out.println("Nastavenie desatinnej ciarky"+wholePart);
			int decDelimiter=-1;
			decDelimiter = newValue.indexOf(".");
			if (decDelimiter==-1) {
				decDelimiter = newValue.indexOf(",");
			}
			//System.out.println("Pozicia desatinnej ciarky"+decDelimiter);
			
			int decimalPart = maskString.length() - wholePart-1;
			String expr;
			if(wholePart>-1) {
				expr = "\\d{0,"+String.valueOf(wholePart)+"}([\\.\\,]\\d{0,"+String.valueOf(decimalPart)+"})?";
			} else {
				expr = "\\d{0,"+String.valueOf(maskString.length())+"}";
			}
			
			if (!newValue.matches(expr)) {
				this.setText(oldValue);
			}
			if (wholePart==-1 && (decDelimiter>-1) ) {
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
