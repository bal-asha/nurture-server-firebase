package org.org.bal.asha.app.server.app.rest;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.AllArgsConstructor;
import org.org.bal.asha.app.server.app.domain.WorkerTask;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private Firestore firestore;
    @PostMapping
    public WorkerTask createTask(@RequestBody WorkerTask workerTask) throws ExecutionException, InterruptedException {
        CollectionReference tasks = firestore.collection("tasks");
        ApiFuture<DocumentReference> result = tasks.add(workerTask);
        return result.get().get().get().toObject(WorkerTask.class);
    }

    @GetMapping
    public List<WorkerTask> getAllTasks() throws ExecutionException, InterruptedException {
        CollectionReference tasks = firestore.collection("worker_task");
        List<WorkerTask> workerTaskList = tasks.get().get().toObjects(WorkerTask.class);
        return workerTaskList;
    }

    @GetMapping("/{id}")
    public WorkerTask getTaskById(@PathVariable String id) throws ExecutionException, InterruptedException {
        DocumentReference taskRef = firestore.collection("tasks").document(id);
        DocumentSnapshot document = taskRef.get().get();
        return document.toObject(WorkerTask.class);
    }

    @PutMapping("/{id}")
    public WorkerTask updateTask(@PathVariable String id, @RequestBody WorkerTask updatedWorkerTask) throws ExecutionException, InterruptedException {
        DocumentReference taskRef = firestore.collection("tasks").document(id);
        taskRef.set(updatedWorkerTask);
        return updatedWorkerTask;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        DocumentReference taskRef = firestore.collection("tasks").document(id);
        taskRef.delete();
    }
}

