package adapter;

import exception.AutoException;

/**
 * Create Automobile Interface.
 * @author Jiaqi Zhang
 *
 */
public interface CreateAuto {

	/**
	 * Builds an instance of Automobile.
	 * @param fileName input file name including model information
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void buildAuto(String fileName, int fileType) throws AutoException;

	/**
	 * Searches and Prints the properties of a given Automodel.
	 * @param modelName model name
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void printAuto(String modelName) throws AutoException;

	/**
	 * Prints the properties of all Automobile.
	 * @throws AutoException auto exception when option set or option not found
	 */
	public void printAllAuto() throws AutoException;
}
