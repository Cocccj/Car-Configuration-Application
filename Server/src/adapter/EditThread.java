package adapter;

import exception.AutoException;

/**
 * Edit thread interface.
 * Edit options in multithread way.
 * @author Jiaqi Zhang
 *
 */
public interface EditThread {

	/**
	 * Searches the Model for a given OptionSet and Option name, 
	 * and sets the option name to new name.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName old option name
	 * @param newName new option name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void updateOptionName(String modelName, String optionSetName,
			String optionName, String newName) throws AutoException;

	/**
	 * Searches the Model for a given OptionSet and Option name, 
	 * and sets the price to new price.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName option name
	 * @param newPrice option price
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) throws AutoException;

}
