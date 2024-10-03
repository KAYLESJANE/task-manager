package com.ikusasa.task_manager.Controller;

import com.ikusasa.task_manager.model.DataModel;
import com.ikusasa.task_manager.service.DataModelService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DataModelController manages CRUD operations for DataModels.
 * Provides endpoints for creating, reading, updating, and deleting Data Models,
 * along with AI-driven task suggestions and due date predictions.
 */
@RestController
@RequestMapping("/datamodel")
public class DataModelController {

    private final DataModelService dataModelService;
    private DataModel defaultDataModel;

    /**
     * Constructor that initializes the service and sets a default DataModel.
     */
    public DataModelController(DataModelService dataModelService) {
        this.dataModelService = dataModelService;
        initializeDefaultDataModel();
    }

    /**
     * Initializes a default DataModel to return if no valid data is found.
     */
    private void initializeDefaultDataModel() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date defaultDueDate = formatter.parse("2024/10/02");
            this.defaultDataModel = new DataModel("default", "Default Title", "Default Description", defaultDueDate, false, "low");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a specific DataModel by ID.
     * @param modelId ID of the DataModel to retrieve.
     * @return DataModel object or the default DataModel if not found.
     */
    @GetMapping("/{modelId}")
    public DataModel getDataModelDetails(@PathVariable("modelId") String modelId) {
        DataModel dataModel = dataModelService.getDataModel(modelId);
        return (dataModel != null) ? dataModel : defaultDataModel;
    }

    /**
     * Retrieves all DataModels from the database.
     * @return List of DataModels or a list containing the default DataModel if none are found.
     */
    @GetMapping
    public List<DataModel> getAllDataModelDetails() {
        List<DataModel> dataModels = dataModelService.getAllDataModel();
        return (dataModels != null && !dataModels.isEmpty()) ? dataModels : List.of(defaultDataModel);
    }

    /**
     * Creates a new DataModel.
     * @param dataModel DataModel object sent in the request body.
     * @return Success message.
     */
    @PostMapping
    public String createDataModelDetails(@RequestBody DataModel dataModel) {
        String result = dataModelService.createDataModel(dataModel);
        return result;
    }

    /**
     * Updates an existing DataModel by ID.
     * @param modelId ID of the DataModel to update.
     * @param dataModel Updated DataModel object.
     * @return Success message.
     */
    @PutMapping("/{modelId}")
    public String updateDataModelDetails(@PathVariable("modelId") String modelId, @RequestBody DataModel dataModel) {
        dataModel.setId(modelId);
        String result = dataModelService.updateDataModel(dataModel);
        return result;
    }

    /**
     * Deletes a DataModel by ID.
     * @param modelId ID of the DataModel to delete.
     * @return Success message.
     */
    @DeleteMapping("/{modelId}")
    public String deleteDataModelDetails(@PathVariable("modelId") String modelId) {
        String result = dataModelService.deleteDataModel(modelId);
        return result;
    }

    /**
     * Suggests task titles or descriptions based on user input using basic AI logic.
     * @param userInput String input from the user.
     * @return List of suggested task titles or descriptions.
     */
    @PostMapping("/tasks/suggest")
    public List<String> suggestTask(@RequestBody String userInput) {
        List<String> suggestions = new ArrayList<>();
        if (userInput.contains("assignment")) {
            suggestions.add("Complete Microsoft Exam");
            suggestions.add("Finish Coding Assignment");
            suggestions.add("Review Assignment Guidelines");
        } else if (userInput.contains("meeting")) {
            suggestions.add("Prepare for Client Meeting");
            suggestions.add("Schedule Team Meeting");
        } else {
            suggestions.add("General Task Suggestion 1");
            suggestions.add("General Task Suggestion 2");
        }
        return suggestions;
    }

    /**
     * Predicts a due date for a task based on past completion times.
     * @param taskId ID of the task to predict the due date for.
     * @return Predicted due date (3 days from the current date as a placeholder).
     */
    @PostMapping("/tasks/{id}/predict-due-date")
    public Date predictDueDate(@PathVariable("id") String taskId) {
        DataModel task = dataModelService.getDataModel(taskId);
        long averageCompletionTime = 3 * 24 * 60 * 60 * 1000L; // 3 days in milliseconds
        Date currentDate = new Date();
        return new Date(currentDate.getTime() + averageCompletionTime);
    }
}
