package adapter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.AutoException;
import model.*;
import scale.EditOptions;
import util.FileIO;

/**
 * Abstract Proxy Automobile class.
 * @author Jiaqi Zhang
 *
 */
public abstract class ProxyAutomobile {

	/**
	 * LinkedHashMap stores information about different models.
	 */
	private static LinkedHashMap<String, Automobile> auto =
								new LinkedHashMap<String, Automobile>();

	/**
	 * Builds an instance of Automobile.
	 * Cannot build many models simultaneously, to make sure consistency.
	 * @param fileName input file name including model information
	 * @throws AutoException auto exception when information not found
	 */
	public synchronized void buildAuto(String fileName, int fileType) throws AutoException{
		Automobile newAuto = null;
		if (fileType == 0) { // text file
			newAuto = FileIO.buildAutoObject(fileName);
		} else if (fileType == 1) {
			newAuto = FileIO.buildAutoFromProp(fileName);
		} else {
			throw new AutoException(6);
		}
		auto.put(newAuto.getName(), newAuto);
	}

	/**
	 * Fix the auto exception.
	 * @param e auto exception
	 */
	public void fix(AutoException e) {
		e.fix(e.getErrorNo());
	}

	/**
	 * Prints the properties of a given Automodel.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 */
	public void printAuto(String modelName) {
		if (auto.containsKey(modelName)) {
			Automobile automobile = auto.get(modelName);
			automobile.print();
		}
	}

	/**
	 * Searches the Model for a given OptionSet, 
	 * and sets the name of OptionSet to new name.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param newName new name of the option set
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void updateOptionSetName(String modelName, 
			String optionSetName, String newName) throws AutoException {
		Automobile automobile = auto.get(modelName);
		automobile.updateOptionSetName(optionSetName, newName);
	}

	/**
	 * Searches the Model for a given OptionSet and Option name, 
	 * and sets the option name to new name.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName old option name
	 * @param newName new option name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void updateOptionName(String modelName, String optionSetName,
			String optionName, String newName) throws AutoException {
		Automobile automobile = auto.get(modelName);
		EditOptions edit = new EditOptions(automobile, optionSetName, optionName, newName);
		edit.start();
	}

	/**
	 * Searches the Model for a given OptionSet and Option name, 
	 * and sets the price to new price.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName option name
	 * @param newPrice option price
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) throws AutoException {
		Automobile automobile = auto.get(modelName);
		EditOptions edit = new EditOptions(automobile, optionSetName,
										optionName, newPrice);
		edit.start();
	}

	/**
	 * Prints the properties of all Automobile.
	 * Synchronization is implemented in Automobile class.
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void printAllAuto() {
		Iterator<Entry<String, Automobile>> iterator = 
											auto.entrySet().iterator();
		while(iterator.hasNext()) {
			Automobile automobile = iterator.next().getValue();
			automobile.print();
			System.out.println("-----------------------------------\n");
		}
	}

	/**
	 * Delete option in specific model.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName option name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void deleteOption(String modelName, String optionSetName,
			String optionName) throws AutoException {
		Automobile automobile = auto.get(modelName);
		automobile.deleteOption(optionName, optionSetName);
	}

	/**
	 * Delete option set in specific model.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void deleteOptionSet(String modelName, 
						String optionSetName) throws AutoException {
		Automobile automobile = auto.get(modelName);
		automobile.deleteOptionSet(optionSetName);
	}
	
	/**
	 * Delete the model information.
	 * Cannot delete many models simultaneously, to make sure consistency.
	 * @param modelName model name
	 */
	public synchronized void deleteModel(String modelName) {
		auto.remove(modelName);
	}

	/**
	 * Set the option choice in specific model.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param choice option choice name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void setOptionChoice(String modelName, String optionSetName,
			String choice) throws AutoException {
		Automobile automobile = auto.get(modelName);
		automobile.setOptionChoice(optionSetName, choice);
	}

	/**
	 * Get the option price in specific model. 
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName option name
	 * @return option price
	 * @throws AutoException auto exception when option set or option not found
	 */
	public float getOptionPrice(String modelName, String optionSetName,
					String optionName) throws AutoException {
		Automobile automobile = auto.get(modelName);
		return automobile.getOptionPrice(optionName, optionSetName);
	}

	/**
	 * Get the option choice in specific model.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @return choice name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public String getOptionChoice(String modelName, 
					String optionSetName) throws AutoException {
		Automobile automobile = auto.get(modelName);
		return automobile.getOptionChoice(optionSetName);
	}

	/**
	 * Get total price of the automobile and selected options.
	 * Synchronization is implemented in Automobile class.
	 * @param modelName model name
	 * @return total price
	 */
	public float getAutoTotalPrice(String modelName) {
		Automobile automobile = auto.get(modelName);
		return automobile.getTotalPrice();
	}
	
	/**
	 * Add the new instance of Automobile to the LinkedHashMap.
	 * @param a automobile to add
	 * @throws AutoException auto exception when information not found
	 */
	public void addAuto(Automobile a) throws AutoException {
		auto.put(a.getName(), a);
	}

	/**
	 * Provide list of models.
	 * @return a string of models list
	 */
	public String provideModelList() {
		StringBuilder list = new StringBuilder();
		Iterator<String> iterator = auto.keySet().iterator();
		while(iterator.hasNext()) {
			list.append(iterator.next()).append("\n");
		}
		return list.toString();
	}

	/**
	 * Get the automobile.
	 * @param autoName automobile name
	 * @return automobile
	 */
	public Automobile getAuto(String autoName) {
		return auto.get(autoName);
	}
}
