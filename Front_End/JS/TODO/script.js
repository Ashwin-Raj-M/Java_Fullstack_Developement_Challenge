const addButton = document.getElementById('addTaskButton');
const inputTask = document.getElementById('addTaskField');
const todoContainer = document.getElementById('tasksTodoContainer');
const todoTemplate = document.getElementById('tasksTodoTemplate');
const doneContainer = document.getElementById('tasksDoneContainer');
const doneTemplate = document.getElementById('tasksDoneTemplate');

addButton.addEventListener('click', () => {
    const taskContent = inputTask.value.trim();

    if (taskContent) {
        const newTaskCard = todoTemplate.cloneNode(true);
        const taskText = newTaskCard.querySelector('p');
        taskText.textContent = taskContent;

        newTaskCard.classList.remove('tasks-todo-template');
        todoContainer.appendChild(newTaskCard);
        inputTask.value = '';

        // Mark as done
        const checkIcon = newTaskCard.querySelector('.check-icon');
        checkIcon.addEventListener('click', () => {
            moveToDone(newTaskCard, taskContent);
        });

        // Delete task
        const deleteIcon = newTaskCard.querySelector('.delete-icon');
        deleteIcon.addEventListener('click', () => {
            newTaskCard.remove();
        });

        // Gripper functionality (to indent task box)
        const gripIcon = newTaskCard.querySelector('.gripper');
        gripIcon.addEventListener('click', () => {
            const task = newTaskCard.querySelector('.task');
            task.style.marginLeft = "50px";
            const taskBox = newTaskCard.querySelector('.task-box');
            taskBox.style.width = "250px";
        });
    } else {
        alert('Please enter a task.');
    }
});

function moveToTODO(taskCard, content) {
    const newTaskCard = todoTemplate.cloneNode(true);
    const taskText = newTaskCard.querySelector('p');
    taskText.textContent = content;

    newTaskCard.classList.remove('tasks-todo-template');
    todoContainer.appendChild(newTaskCard);
    taskCard.remove();

    // Mark as done
    const checkIcon = newTaskCard.querySelector('.check-icon');
    checkIcon.addEventListener('click', () => {
        moveToDone(newTaskCard, content);
    });

    // Delete task
    const deleteIcon = newTaskCard.querySelector('.delete-icon');
    deleteIcon.addEventListener('click', () => {
        newTaskCard.remove();
    });

    // Gripper functionality (to indent task box)
    const gripIcon = newTaskCard.querySelector('.gripper');
    gripIcon.addEventListener('click', () => {
        const task = newTaskCard.querySelector('.task');
        task.style.marginLeft = "50px";
        const taskBox = newTaskCard.querySelector('.task-box');
        taskBox.style.width = "250px";
    });
}

function moveToDone(taskCard, content) {
    const doneTaskCard = doneTemplate.cloneNode(true);
    const taskText = doneTaskCard.querySelector('p');
    taskText.textContent = content;

    doneTaskCard.classList.remove('tasks-done-template');
    doneContainer.appendChild(doneTaskCard);
    taskCard.remove();

    // Delete done task
    const deleteIcon = doneTaskCard.querySelector('.delete-icon');
    deleteIcon.addEventListener('click', () => {
        doneTaskCard.remove();
    });

    // Move back to TODO
    const uncheckIcon = doneTaskCard.querySelector('.check-icon'); // Corrected to select the uncheck button
    uncheckIcon.addEventListener('click', () => {
        moveToTODO(doneTaskCard, content);
    });
}
