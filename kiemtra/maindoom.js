const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];

 const btn = document.getElementById("btn");
const answerElement = document.getElementById("answer");

btn.addEventListener("click", () => {
    const questions = document.querySelectorAll('.quiz-item');
    questions.forEach((question) => {
        const radioButtons = question.querySelectorAll('input[type="radio"]');
        const randomIndex = Math.floor(Math.random() * radioButtons.length);
        radioButtons.forEach((radioButton) => {
            radioButton.checked = false;
        });


        radioButtons[randomIndex].checked = true;
    });


});