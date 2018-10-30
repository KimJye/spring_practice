`<form action=URL ?query String>`

`<input ~~~값>`

`<button type="submit">`

> 여기서 submit하면 파라미터값이 두개다 넘어간다.
>
> 하지만 post방식은 url부분은 무시가 되고 get방식은 둘다 넘어가고 입력된 것만 넘어간다.
>
> post일때 입력된것이 request body로 넘어가고 
>
> get일때 입력된것이 query String으로 들어가는데 이때 대체로 들어가서 기존의 url을 날려버리고 들어간다.
>
> 이때 jsp에서는 request.getParameter에서 2개가 넘어올때 3,5로 넘어오기때문에 에러가 나지만
>
> spring은 똑똑해서 자동적으로 배열로 저장이된다.
>
> 이 과정을 서버(서블릿 컨테이너)에서 꺼낼때 해준다.



input 태그의 name이 같을 때 : 전체 체크

`<input name="id" type="checkbox" value="3">`



웹브라우저 							---->	 				서버

				query String 							request parameter

				request body 

				(post 방식입력인것만)			