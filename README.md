## 기능 목록  
> ### 0. ui
>  * 입력과 출력을 담당하는 패키지
>  ```  
>  ✔ <<interface>> InputManager
>    - ScannerInputManager ( 콘솔을 통해 사용자 input을 입력받는 기능 )
>  
>  ✔ <<interface>> OutputManager
>   - PrintOutputManager ( 콘솔을 통해 output을 출력하는 기능 )
>  ```

> ### 1. car 
>  * 경주 게임 자동차 관련 패키지
>  ```
>  ✔ Car ( 이름과 이동거리를 가지는 자동차, 움직임 )
>
>  ✔ Cars ( 여러 Car 객체를 관리하는 일급 컬렉션 )
>  
>  ✔ <<interface>> MoveStrategy
>   - ForwardStrategy ( 자동차가 전진하는 전략 )
>   - StopStrategy ( 자동차가 멈추는 전략 )
>  ```

>### 2. digit
>  * 랜덤숫자 관련 패키지
>  ```
>  ✔ RandomDigits ( 0에서 9 사이에서 random 값을 발생 )
>  ```

>### 3. game
>  * 자동차 경주 게임 패키지
>  ```
>  ✔ Game ( 게임 흐름 전개 )
>  ```
