package adapter;

import exception.AutoException;

/**
 * Updating Auto information Interface.
 * @author Jiaqi Zhang
 *
 */
public interface UpdateAuto {

	/**
	 * Searches the Model for a given OptionSet, 
	 * and sets the name of OptionSet to new name.
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param newName new name of the option set
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void updateOptionSetName(String modelName, 
			String optionSetName, String newName) throws AutoException;

	/**
	 * Delete option set in specific model. 
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void deleteOptionSet(String modelName, 
						String optionSetName) throws AutoException;


	/**
	 * Delete option in specific model. 
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName option name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void deleteOption(String modelName, String optionSetName,
			String optionName) throws AutoException;

	/**
	 * Delete the model information.
	 * @param modelName model name
	 */
	public void deleteModel(String modelName);

	/**
	 * Set the option choice in specific model. 
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param choice option choice name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void setOptionChoice(String modelName, String optionSetName,
			String choice) throws AutoException;

	/**
	 * Get the option price in specific model. 
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @param optionName option name
	 * @return option price
	 * @throws AutoException auto exception when option set or option not found
	 */
	public float getOptionPrice(String modelName, String optionSetName,
					String optionName) throws AutoException;

	/**
	 * Get the option choice in specific model. 
	 * @param modelName model name
	 * @param optionSetName option set name
	 * @return choice name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public String getOptionChoice(String modelName, 
					String optionSetName) throws AutoException;

	/**
	 * Get total price of the automobile and selected options.
	 * @param modelName model name
	 * @return total price
	 */
	public float getAutoTotalPrice(String modelName);

}
