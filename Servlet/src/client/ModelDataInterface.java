package client;

import model.Automobile;

/**
 * Interface for retrieving model data, the methods can be called by the servlet. 
 * @author Jiaqi Zhang
 *
 */
public interface ModelDataInterface {

	/**
     * Get the list of available models.
     * @return a string of models
     */
    public String getModelList();

    /**
     * Get model information.
     * @param model model name
     * @return automobile
     */
    public Automobile getModelInfo(String model);
}
