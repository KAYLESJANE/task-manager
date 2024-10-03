package com.ikusasa.task_manager.service;

import com.ikusasa.task_manager.model.DataModel;
import java.util.List;

/**
 * DataModelService interface provides service methods for creating, updating,
 * deleting, and retrieving DataModels from the database.
 */
public interface DataModelService {

    public String createDataModel(DataModel dataModel);
    public String updateDataModel(DataModel dataModel);
    public String deleteDataModel(String dataModelId);
    public DataModel getDataModel(String dataModelId);
    public List<DataModel> getAllDataModel();
}
