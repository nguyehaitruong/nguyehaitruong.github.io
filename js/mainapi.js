const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('breed-list');  // Thay 'select' bằng 'breed-list'
const dogBreeds = {
    "affenpinscher": [],
    "african": [],
    "airedale": [],
    "akita": [],
    "appenzeller": []
};

// Thêm các tùy chọn vào phần tử select
for (const breed in dogBreeds) {
    const option = document.createElement("option");
    option.value = breed;
    option.textContent = breed;
    select.appendChild(option);  // Sử dụng 'select' thay vì 'selectElement'
}

const getImage = async () => {
    try {
        const selectedBreed = select.value;  // Lấy giá trị đã chọn từ phần tử select
        const res = await fetch(`https://dog.ceo/api/breed/${selectedBreed}/images/random`);
        const data = await res.json();
        image.src = data.message;
    } catch (error) {
        console.log(error);
    }
};

btn.addEventListener("click", getImage);
