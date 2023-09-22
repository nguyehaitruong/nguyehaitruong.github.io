const users = [
    {
        name: "Nanako Minos",
        quote: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Inventore quam consectetur libero in vitae natus non repellat assumenda consequuntur, eos minus facere? Totam distinctio ipsum dolorum officia sint iste ullam?.",
        image: "https://randomuser.me/api/portraits/men/41.jpg",
        color: "red"
    },
    {
        name: "Nina Lihuén",
        quote: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Inventore quam consectetur libero in vitae natus non repellat assumenda consequuntur, eos minus facere? Totam distinctio ipsum dolorum officia sint iste ullam?.",
        image: "https://randomuser.me/api/portraits/women/50.jpg",
        color: "orange"
    },
    {
        name: "Siv Phaidros",
        quote: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Inventore quam consectetur libero in vitae natus non repellat assumenda consequuntur, eos minus facere? Totam distinctio ipsum dolorum officia sint iste ullam?",
        image: "https://randomuser.me/api/portraits/women/22.jpg",
        color: "yelow"
    },
    {
        name: "Iúile Asia",
        quote: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Inventore quam consectetur libero in vitae natus non repellat assumenda consequuntur, eos minus facere? Totam distinctio ipsum dolorum officia sint iste ullam?",
        image: "https://randomuser.me/api/portraits/women/76.jpg",
        color: "green"
    },
    {
        name: "Svetomir Heidrich",
        quote: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Inventore quam consectetur libero in vitae natus non repellat assumenda consequuntur, eos minus facere? Totam distinctio ipsum dolorum officia sint iste ullam?",
        image: "https://randomuser.me/api/portraits/men/17.jpg",
        color: "blue"
    }
];

document.addEventListener('DOMContentLoaded', () => {
    const testimonialsContainer = document.querySelector('.testimonials-container');
    const textElement = document.querySelector('.text');
    const nameElement = document.querySelector('.name');
    const authors = document.querySelectorAll('.author');
    const updateUserDisplay = (user) => {
        textElement.innerText = user.quote;
        nameElement.innerText = user.name;
        testimonialsContainer.style.backgroundColor = user.color;
        authors.forEach(author => {
            author.classList.remove('selected');
        });
        const selectedAuthor = Array.from(authors).find(author => author.querySelector('img').src === user.image);
        selectedAuthor.classList.add('selected');
    };
    authors.forEach(author => {
        author.addEventListener('click', () => {
            const selectedUser = users.find(user => user.image === author.querySelector('img').src);
            updateUserDisplay(selectedUser);
        });
    });
    updateUserDisplay(users[0]);
});
