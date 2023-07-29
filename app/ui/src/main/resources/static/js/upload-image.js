function uploadImage() {
    const fileInput = document.getElementById('image');
    const formData = new FormData();
    formData.append('file', fileInput.files[0]);

    fetch('http://localhost:8080/posts/upload-image', {
        method: 'post',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('imageId').value = data.data.id;
            alert('이미지 업로드 성공');
        })
        .catch(error => {
            console.error('Error:', error);
            alert('이미지 업로드 실패');
        });
}
