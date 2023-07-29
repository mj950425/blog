document.addEventListener("DOMContentLoaded", function() {
    let commentForm = document.getElementById("comment-form");

    commentForm.addEventListener("submit", function(event) {
        event.preventDefault();

        let author = document.getElementById("author").value;
        let content = document.getElementById("content").value;
        let postId = Number(document.getElementById("postId").value);

        let xhr = new XMLHttpRequest();
        let url = "/comments";
        let data = JSON.stringify({author: author, content: content, postId: postId});

        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onload = function() {
            if (xhr.status >= 200 && xhr.status < 400) {
                // 성공 시 코멘트 리스트에 새로운 코멘트 추가
                const newComment = `
                    <div class="card mb-3">
                        <span>
                            <img src="/images/commentImage.png" alt="comment image"
                                 style="width: 30px; height: 30px; margin-right: 5px; vertical-align: middle;">
                            <strong>${author}</strong>
                        </span>
                        <span>${content}</span>
                    </div>
                `;
                let commentsContainer = document.getElementById("comments-container");
                commentsContainer.insertAdjacentHTML("beforeend", newComment);

                // 폼 초기화
                document.getElementById("postId").value = "";
                document.getElementById("author").value = "";
                document.getElementById("content").value = "";
            } else {
                console.error("Server returned an error:", xhr.statusText);
            }
        };

        xhr.onerror = function() {
            console.error("Error:", xhr.statusText);
        };

        xhr.send(data);
    });
});
