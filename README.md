# 서울시 착한 가격 업소 정보<br><br>
## 1.로그인 페이지
## 2.회원가입 페이지<br><br>
<div display: inline-block;>
<p><img src="https://user-images.githubusercontent.com/48502969/59730242-9aaade00-927c-11e9-9339-50ddab03949f.png" width="300" height="600" ></p>
<p><img src="https://user-images.githubusercontent.com/48502969/59731171-15292d00-9280-11e9-90a8-da1a20789c22.png" width="300" height="600"></p>
</div>

### 파이어베이스 사용<br>
-로그인 기능은 구글API의 파이어베이스를 이용하여 구현하였습니다.

-회원가입시 파이어베이스에 등록이 되며 로그인시에 저장된 가입 정보를 불러와 로그인이 되게 하였습니다.

#### 사용 코드

-로그인

        private void login() {
                String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
                String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();

        if (email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다", Toast.LENGTH_LONG).show();
                                myStartActivity(MainActivity.class);
                            } else {
                                if (task.getException() != null) {
                                }
                            }
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), "이메일 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_LONG).show();
        }
    }
    
-회원가입

        private void signUp() {
                String email = ((EditText)findViewById(R.id.emailEditText)).getText().toString();
                String password = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();
                String passwordCheck = ((EditText)findViewById(R.id.passwordCheckEditText)).getText().toString();

        if(email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0){
            if(password.equals(passwordCheck)){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getApplicationContext(), "회원가입에 성공하였습니다", Toast.LENGTH_LONG).show();
                                    myStartActivity(LoginActivity.class);
                                } else {
                                    if(task.getException() != null){
                                            }
                                        }
                                    }
                                });
                    }else{
                        Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "이메일 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_LONG).show();
                }
            }
## 3-1.프래그먼트 페이지1<br>
<div display: inline-block;>
 <img src="https://user-images.githubusercontent.com/48502969/59731970-53741b80-9283-11e9-8219-cfb3831814fd.png" width="250" height="500">
 <img src="https://user-images.githubusercontent.com/48502969/59731969-4fe09480-9283-11e9-9de2-80d7763d6c46.png" width="250" height="500">
 <img src="https://user-images.githubusercontent.com/48502969/59731964-4ce5a400-9283-11e9-959d-d2eb097a3768.png" width="250" height="500">
 </div>

### 파이어베이스 게시판

 - 게시판 오른쪽 하단에 있는 작성 버튼을 클릭하여 게시판에 올릴 글을 작성한다
 - 내용을 다 작성한 후 등록을 누르면 내가 적은 제목과 별명이 게시판에 추가된 걸 확인할 수 있다.
 
#### 사용 코드 

    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
                           ...
    id = mStore.collection("board").document().getId();

        Map<String, Object> post = new HashMap<>();
        post.put("id", id);
        post.put("title", mWriteTitleText.getText().toString());
        post.put("contents", mWriteContentsText.getText().toString());
        post.put("name", mWriteNameText.getText().toString());
                            ...
 
 
## 3-2.프래그먼트 페이지2<br>
<img src="https://user-images.githubusercontent.com/48502969/59731176-16f2f080-9280-11e9-9e1a-b5708a3f037d.png" width="300" height="600">
### 리스트로 업소현황, 정보를 가져옵니다.<br>
- 서울 열린 데이터 광장의 openAPI를 이용하여 뿌려주는 데이터를 파싱, 리사이클러뷰에 불러온 데이터를 보여줍니다.

#### 사용 코드

- 파싱된 데이터를 불러오와 리사이클러뷰에 보여주는 

        private void getStoresRespons() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://openapi.seoul.go.kr:8088/526747566773657534335a636f7853/json/ListPriceModelStoreService/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<StoresModels> call = requestInterface.getStoresJson();
        call.enqueue(new Callback<StoresModels>() {
            @Override
            public void onResponse(Call<StoresModels> call, Response<StoresModels> response) {
                storesAdaptar = new StoresAdaptar(getActivity(), response.body().getListPriceModelStoreService().getRow());
                stores_recyclerview.setAdapter(storesAdaptar);
                Toast.makeText(getActivity(), "성공하였습니다", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<StoresModels> call, Throwable t) {
                Toast.makeText(getActivity(), "실패다", Toast.LENGTH_LONG).show();
            }
        });
    }

## 3-3.프래그먼트 페이지3<br>
<div display: inline-block;>
<img src="https://user-images.githubusercontent.com/48502969/59731192-1e19fe80-9280-11e9-977c-b25a1c7c856c.png" width="300" height="600">
<img src="https://user-images.githubusercontent.com/48502969/59731194-1fe3c200-9280-11e9-8dd1-62ad97f7d6a4.png" width="300" height="600">
</div>

### 지도, 검색, 현황<br>

- 프래그먼트3은 googleMaps API를 이용하였습니다.
- 처음 페이지를 불러오면 현재 위치값을 가져와 표시하고 플로팅 버튼을 통해서도 현재위치값을 가져올 수 있습니다.

- 검색기능은 지오코딩을 이용하여 위치를 입력하였을때 좌표값으로 변환, 카메라를 이동하게 하였습니다.

#### 사용 코드<br>

-현재위치를 불러오는 기능.

        private void fectcLastLocation() {
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
                    return;
                }
                final Task<Location> task = fusedLocationProviderClient.getLastLocation();
                task.addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            currentLocation = location;

                    SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(TabFragment3.this);
                }
            }
        });
    }
    
    -검색 버튼에 연결된 GEOCODING
    
     btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String place = editPlace.getText().toString();
                Geocoder coder = new Geocoder(getActivity());
                List<Address> list = null;
                try {
                    list = coder.getFromLocationName(place, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list.size() < 1) {
                    Toast.makeText(getActivity(), "검색된 위치가 없습니다", Toast.LENGTH_LONG).show();
                } else {
                    Address addr = list.get(0);
                    double lat = addr.getLatitude();
                    double log = addr.getLongitude();
                    LatLng geoPoint = new LatLng(lat, log);
                    if (geoPoint == null) {
                        fectcLastLocation();
                        Toast.makeText(getActivity(), "주소를 자세히 입력해 주세요", Toast.LENGTH_LONG).show();
                    } else {
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(geoPoint, 15));
                    }
                }
            }
        }
