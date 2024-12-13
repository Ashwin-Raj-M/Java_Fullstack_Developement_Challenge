import dayjs from 'https://unpkg.com/dayjs@1.11.10/esm/index.js';

// console.log(dayjs().add(7, 'days').format('dddd, MMMM D'));

//function to format date
export function dateFormatter(deliveryTime){
  return dayjs().add(deliveryTime, 'days').format('dddd, MMMM D');
}

//function to get current date 
export function currentDate(){
  return dayjs().format('dddd, MMMM D');
}