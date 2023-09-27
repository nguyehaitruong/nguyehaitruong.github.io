const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('breed-list');  
const dogBreeds = {
    "affenpinscher": [],
    "african": [],
    "airedale": [],
    "akita": [],
    "appenzeller": []
};


for (const breed in dogBreeds) {
    const option = document.createElement("option");
    option.value = breed;
    option.textContent = breed;
    select.appendChild(option);
}

const getImage = async () => {
    try {
        const selectedBreed = select.value;  
        const res = await fetch(`https://dog.ceo/api/breed/${selectedBreed}/images/random`);
        const data = await res.json();
        image.src = data.message;
    } catch (error) {
        console.log(error);
    }
};

btn.addEventListener("click", getImage);
