# JSONParser

  var users = [
    { id: 1, name: 'ID', age: 36 },
    { id: 2, name: 'BJ', age: 32 },
    { id: 3, name: 'JM', age: 32 },
    { id: 4, name: 'PJ', age: 27 },
    { id: 5, name: 'HA', age: 25 },
    { id: 6, name: 'JE', age: 26 },
    { id: 7, name: 'JI', age: 31 },
    { id: 8, name: 'MP', age: 23 }
  ];


  var data = {
      Name: "SooYoung"
      , Age: "27"
  }
  var person = JSON.stringify(data);
  var oPerson = JSON.parse(person);

  console.log(person);
  console.log(oPerson);

  <front-end>
      function signup()
      {
      	var member = {
      		"email": "test@naver.com",
      		"password": "1234"
      	};

      	$.ajax({
      		url : '/account/signup',
      		dataType : 'json',
      		type : 'POST',
      		data : JSON.stringify(member), //그냥 member 사용하면 error 발생!
      		contentType : 'application/json; charset=UTF-8',
      		success : function(result) {
      			console.log(result);
      		}
      	});
      }

  <back-end>
  	@RequestMapping(value = "/signup", method = RequestMethod.POST)
  	public MemberResultDto signup(@RequestBody Member member)
  	{
  		systemLog.info("try to sign up..");
  		return memberResultDto;
  	}

  @RequestBody는 HTTP요청의 body 내용을 자바 객체로 매핑 하는 역할을 합니다.
