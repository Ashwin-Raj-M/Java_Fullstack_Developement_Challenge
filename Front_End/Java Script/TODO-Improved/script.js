const inputTextBox = document.querySelector('.addTask');
const inputDateBox = document.querySelector('.addDue');
const addButton = document.querySelector('.addIcon');
const TODOContainer = document.querySelector('.tasksTodoContainer');
const deleteButton = document.querySelector('.delete-icon');
const DONEContainer = document.querySelector('.tasksDoneContainer');

const taskList = [{
    taskContent: 'Test Task',
    taskDue: 'Test Date' 
}];

const doneTaskList = [];

function renderTODO(){
    let htmlTask = ``;
    taskList.forEach((value, index) => {
        htmlTask += `
        <div class="tasks-todo-template" id="tasksTodoTemplate">
            <div class="task">
                <img src="check_box_outline_blank_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="check-icon" alt="check" onclick="moveToDone(${index})">
                <div class="task-box">
                    <img src="grip-vertical-solid.svg" class="gripper" alt="Gripper">
                    <p>
                        ${value.taskContent}
                    </p>
                    <div class="dueDateBox">
                        <p class="dueDate">
                            <span class="accent1">
                            Should Be Done By : </span>
                            ${value.taskDue}
                        </p>
                    </div>
                </div>
                <img src="delete_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="delete-icon" alt="Delete" onclick="removeTaskFromArray(${index})">
            </div>
        </div>`;
    });
    // console.log(htmlTask);
    TODOContainer.innerHTML = htmlTask;
}

function renderDONE(){
    let htmlTask = ``;
    doneTaskList.forEach((value, index) => {
        htmlTask += `
        <div class="tasks-todo-template" id="tasksTodoTemplate">
            <div class="task">
                <img src="select_check_box_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="check-icon" alt="check" onclick="moveToTodo(${index})">
                <div class="task-box">
                    <img src="grip-vertical-solid.svg" class="gripper" alt="Gripper">
                    <p>
                        ${value.doneTaskContent}
                    </p>
                    <div class="dueDateBox">
                        <p class="dueDate">
                            Completed On : ${value.doneTaskDue}
                        </p>
                    </div>
                </div>
                <img src="delete_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="delete-icon" alt="Delete" onclick="
                removeTaskFromDoneArray(${index})">
            </div>
        </div>`;
    });
    // console.log(htmlTask);
    DONEContainer.innerHTML = htmlTask;
}

renderTODO();

function moveToDone(index){
    addTaskToDoneArray(index);
    removeTaskFromArray(index);
}

function moveToTodo(index){
    addTaskToArrayOL(index);
    removeTaskFromDoneArray(index);
}

function removeTaskFromDoneArray(index){
    doneTaskList.splice(index,1);
    renderDONE();
    // console.log(`Deleted task at ${index}`);
}

function removeTaskFromArray(index){
    taskList.splice(index,1);
    renderTODO();
    // console.log(`Deleted task at ${index}`);
};

function addTaskToDoneArray(index){
    const doneTaskContent = taskList[index].taskContent;
    const doneTaskDue = taskList[index].taskDue;

    doneTaskList.push({
        doneTaskContent,
        doneTaskDue
    })
    // console.log(doneTaskList);
    renderDONE();
}

function addTaskToArrayOL(index){
    const taskContent = doneTaskList[index].doneTaskContent;
    const taskDue = doneTaskList[index].doneTaskDue;

    taskList.push({
        taskContent,
        taskDue
    })
    // console.log(taskList);
    renderTODO();
}

function addTaskToArray(){
    const taskContent = inputTextBox.value.trim();
    const taskDue = inputDateBox.value.trim();

    if (!(taskContent === "" || taskDue === "")) {
        taskList.push({
            taskContent,
            taskDue
        });
        inputTextBox.value = '';
        inputDateBox.value = '';
    }
    else {
        alert("Please fill out both fields!");
        return;
    }
    // console.log(taskContent);
    // console.log(taskDue);
    // console.log(taskList);
    renderTODO();
}

const addTaskOnClick = () => {
    addTaskToArray();
}

const addTaskOnEnter = (event) => {
    if(event.key === 'Enter') addTaskToArray();
}

addButton.addEventListener('click', addTaskOnClick);
document.body.addEventListener('keydown', addTaskOnEnter);

