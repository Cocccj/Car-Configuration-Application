package server;


import exception.AutoException;
import model.Automobile;

/**
 * AutoServer Interface.
 * @author Jiaqi Zhang
 *
 */
public interface AutoServer {

	/**
	 * Add the new instance of Automobile to the LinkedHashMap.
	 * @param auto automobile to add
	 * @throws AutoException auto exception when information not found
	 */
	public void addAuto(Automobile auto) throws AutoException;
	
	/**
	 * Provide list of models.
	 * @return a string of models list
	 */
	public String provideModelList();

	/**
	 * Get the automobile.
	 * @param autoName automobile name
	 * @return automobile
	 */
	public Automobile getAuto(String autoName);
}
