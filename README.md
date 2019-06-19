# 서울시 착한 가격 업소 정보<br>
## 1.로그인 페이지
![로그인](https://user-images.githubusercontent.com/48502969/59730242-9aaade00-927c-11e9-9339-50ddab03949f.png){: width="30%" height="30%"}
## 2.로그인 페이지<br>
## 2-1.회원가입 페이지<br><br>
## 3-1.프래그먼트 페이지1<br>
### 파이어베이스 게시판
 - 게시판 오른쪽 하단에 있는 작성 버튼을 클릭하여 게시판에 올릴 글을 작성한다
 - 내용을 다 작성한 후 등록을 누르면 내가 적은 제목과 별명이 게시판에 추가된 걸 확인할 수 있다.
#### 사용 코드 
```
private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
id = mStore.collection("board").document().getId();

        Map<String, Object> post = new HashMap<>();
        post.put("id", id);
        post.put("title", mWriteTitleText.getText().toString());
        post.put("contents", mWriteContentsText.getText().toString());
        post.put("name", mWriteNameText.getText().toString());
```
 
## 3-2.프래그먼트 페이지2<br>
### 리스트로 업소현황, 정보<br>
## 3-3.프래그먼트 페이지3<br>
### 지도, 검색, 현황<br>
