const postButton = document.getElementById('postButton');
const photoButton = document.getElementById('photoButton');
const albumsButton = document.getElementById('albumsButton');
const postTypeElement = document.getElementById('postType');
const list = document.getElementById('list');

function changeType(newType) {
    postTypeElement.textContent = newType;
}

postButton.addEventListener('click', () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
        .then(response => response.json())
        .then(data => {
            list.innerHTML = '';
            data.forEach(item => {
                const li = document.createElement('li');
                li.textContent = item.title;
                list.appendChild(li);
            });
        });
});

photoButton.addEventListener('click', () => {
    fetch('https://jsonplaceholder.typicode.com/photos')
        .then(response => response.json())
        .then(data => {
            list.innerHTML = '';
            data.forEach(item => {
                const li = document.createElement('li');
                li.textContent = item.title;
                list.appendChild(li);
            });
        });
});

albumsButton.addEventListener('click', () => {
    fetch('https://jsonplaceholder.typicode.com/albums')
        .then(response => response.json())
        .then(data => {
            list.innerHTML = '';
            data.forEach(item => {
                const li = document.createElement('li');
                li.textContent = item.title;
                list.appendChild(li);
            });
        });
});