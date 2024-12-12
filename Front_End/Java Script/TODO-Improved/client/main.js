const inputTextBox = document.querySelector('.addTask');
const inputDateBox = document.querySelector('.addDue');
const addButton = document.querySelector('.addIcon');
const TODOContainer = document.querySelector('.tasksTodoContainer');
const deleteButton = document.querySelector('.delete-icon');
const DONEContainer = document.querySelector('.tasksDoneContainer');

function getCurrentDate(){
    const currentDate = new Date();
    return `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}`;
}

// const taskList = [{
//     taskContent: 'Test Task',
//     taskDue: 'Test Date' 
// }];
let taskList = JSON.parse(localStorage.getItem('taskList')) || [];
let doneTaskList = JSON.parse(localStorage.getItem('doneTaskList')) || [];

function saveToLocalStorage(){
    localStorage.setItem('taskList', JSON.stringify(taskList));
    localStorage.setItem('doneTaskList', JSON.stringify(doneTaskList));
}

function renderTODO(){

    let htmlTask;

    if(taskList.length === 0){
        htmlTask = `
                <div class="waterMarkTodo">
                    <img src="capability.svg" alt="image" class="noTaskAddedIcon">
                    <p class="noTaskAdded">
                        No Task Added
                    </p>
                </div>`;
    }
    else{
        htmlTask = ``;
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
                                    Expected Date : 
                                </span>
                                ${value.taskDue}
                            </p>
                        </div>
                    </div>
                    <img src="delete_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="delete-icon" alt="Delete" onclick="removeTaskFromArray(${index})">
                </div>
            </div>`;
        });
    }
    // console.log(htmlTask);
    TODOContainer.innerHTML = htmlTask;
}

function renderDONE(){

    let htmlTask;

    if(doneTaskList.length === 0){
        htmlTask = `
                <div class="waterMarkTodo">
                    <img src="capability.svg" alt="image" class="noTaskAddedIcon">
                    <p class="noTaskAdded">
                        No Task Done
                    </p>
                </div>`;
    }
    else{
        htmlTask = ``;
        doneTaskList.forEach((value, index) => {
            htmlTask += `
            <div class="tasks-done-template" id="tasksTodoTemplate">
                <div class="task">
                    <img src="select_check_box_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="check-icon" alt="check" onclick="moveToTodo(${index})">
                    <div class="task-box">
                        <img src="grip-vertical-solid.svg" class="gripper" alt="Gripper">
                        <p class="doneTaskText">
                            ${value.doneTaskContent}
                        </p>
                        <div class="doneDueDateBox">
                            <p class="dueDate">
                                <span class="accent1">
                                    Expected Date : 
                                </span>
                                ${value.doneTaskDue} <br><br>
                                <span class="accent1">
                                    Completed Date : 
                                </span>
                                ${value.doneTaskDate}
                            </p>
                        </div>
                    </div>
                    <img src="delete_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24.svg" class="delete-icon" alt="Delete" onclick="
                    removeTaskFromDoneArray(${index})">
                </div>
            </div>`;
        });
    }
    // console.log(htmlTask);
    DONEContainer.innerHTML = htmlTask;
}

renderTODO();
renderDONE();
// console.log(getCurrentDate());

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
    saveToLocalStorage();
    // console.log(`Deleted task at ${index}`);
}

function removeTaskFromArray(index){
    taskList.splice(index,1);
    renderTODO();
    saveToLocalStorage();
    // console.log(`Deleted task at ${index}`);
};

function addTaskToDoneArray(index){
    const doneTaskContent = taskList[index].taskContent;
    const doneTaskDue = taskList[index].taskDue;
    const doneTaskDate = getCurrentDate();

    doneTaskList.push({
        doneTaskContent,
        doneTaskDue,
        doneTaskDate
    })
    // console.log(doneTaskList);
    renderDONE();
    saveToLocalStorage();
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
    saveToLocalStorage();
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
    saveToLocalStorage();
}

const addTaskOnClick = () => {
    addTaskToArray();
}

const addTaskOnEnter = (event) => {
    if(event.key === 'Enter') addTaskToArray();
}

addButton.addEventListener('click', addTaskOnClick);
document.body.addEventListener('keydown', addTaskOnEnter);