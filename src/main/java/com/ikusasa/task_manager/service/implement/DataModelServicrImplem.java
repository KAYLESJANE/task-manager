package com.ikusasa.task_manager.service.implement;

import com.ikusasa.task_manager.model.DataModel;
import com.ikusasa.task_manager.repository.DataModelRepo;
import com.ikusasa.task_manager.service.DataModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataModelServicrImplem implements DataModelService {
    DataModelRepo dataModelRepo;

    public DataModelServicrImplem(DataModelRepo dataModelRepo){
        this.dataModelRepo = dataModelRepo;
    }

    @Override
    public String createDataModel(DataModel dataModel) {
        dataModelRepo.save(dataModel);
        return "Success";
    }

    @Override
    public String updateDataModel(DataModel dataModel) {
        dataModelRepo.save(dataModel);
        return "success";
    }

    @Override
    public String deleteDataModel(String dataModelId) {
        dataModelRepo.deleteById(dataModelId);
        return "success";
    }

    @Override
    public DataModel getDataModel(String dataModelId) {

        return dataModelRepo.findById(dataModelId).get();
    }

    @Override
    public List<DataModel> getAllDataModel() {
        return dataModelRepo.findAll();
    }
}
