 const para=document.querySelector("#text")
 console.log(para)
 para.style.color='#777'
 para.style.fontSize='2 rem'
 para.innerHTML="Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript"

 const ul=document.querySelectorAll("p+ul")
 console.log(ul)
 ul.forEach(p=>{
    p.style.color='blue'
    }
    )


const newItem8 = document.createElement('li');
newItem8.innerText = "Item 8";

const newItem9 = document.createElement('li');
newItem9.innerText = "Item 9";

const newItem10 = document.createElement('li');
newItem10.innerText = "Item 10";

const ulList = document.querySelector('#list');
ulList.appendChild(newItem8);
ulList.appendChild(newItem9);
ulList.appendChild(newItem10);

const li2 = document.querySelector('#list li:nth-child(2)');
console.log(li2)
li2.style.color='red'

const li3 = document.querySelector('#list li:nth-child(3)');
li3.style.backgroundColor='blue'

const li4 = document.querySelector('#list li:nth-child(4)');
li4.remove();
const li5 = document.querySelector('#list li:nth-child(5)');

const li4remake = document.createElement('li');
li4remake.innerText = " Item 4 remake";
ulList.insertBefore(li4remake, li3);