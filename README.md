## 문자열 덧셈 계산기 구현

### ✏️ 구현할 기능 목록

1. **안내 멘트 출력**
    - "덧셈할 문자열을 입력해 주세요."라는 메시지를 사용자에게 출력한다.
2. **입력값 처리**
    - 사용자로부터 문자열을 입력받는다.
    - 입력값의 앞뒤 공백을 제거한다.
    - 입력된 문자열이 `null`인지 확인하고, `null`일 경우 `IllegalArgumentException`을 발생시켜 프로그램을 종료한다.
    - 음수를 입력한 경우 예외처리
    - 빈 문자열(`""`)이 입력된 경우 0을 반환한다.
3. **커스텀 구분자 처리**
    - 입력값에 커스텀 구분자가 포함되어 있는지 확인한다.
    - 커스텀 구분자는 문자열이 `//`로 시작하고 그 다음에 `\n`이 오는 형태로 정의되며, 이 두 문자 사이에 위치한 구분자를 추출한다.
    - 커스텀 구분자가 있다면 이를 기본 구분자(쉼표 `,`, 콜론 `:`)와 함께 사용하여 입력 문자열을 분리한다.
    - 커스텀 구분자가 없다면 기본 구분자(쉼표 `,`, 콜론 `:`)만을 사용하여 숫자를 분리한다.
4. **문자열 분리 및 숫자 변환**
    - 구분자를 기준으로 입력 문자열을 분리한 후, 각 요소를 숫자로 변환한다.
    - 변환 과정에서 숫자가 아닌 값이 포함된 경우에도 `IllegalArgumentException`을 발생시켜 프로그램을 종료한다.
5. **합계 계산**
    - 변환된 숫자들의 합을 계산한다.
6. **결과 출력**
    - 계산된 합계를 "결과: (합계)" 형식으로 출력한다.

---

## ✅ 기능 체크리스트

### 1. **안내 멘트**

- [x]  "덧셈할 문자열을 입력해 주세요."라는 메시지가 출력되는지 확인한다.

### 2. **입력값 검증**

- [x]  빈 문자열(`""`)이 입력된 경우 0을 반환하는지 확인한다.

### 3. **커스텀 구분자 처리**

- [x]  커스텀 구분자가 존재할 때, `//`와 `\n` 사이의 구분자가 정확히 추출되는지 확인한다.
- [x]  커스텀 구분자가 없는 경우 기본 구분자(쉼표 `,`, 콜론 `:`)로 처리되는지 확인한다.
- **예상 엣지 케이스**:
    - [x]  커스텀 구분자가 여러 문자일 경우 예외가 발생하는지 확인한다.
    - [x]  커스텀 구분자가 - 일 경우 음수가 아닌 커스텀 구분자로 인식하는지 확인한다.
    - [x]  커스텀 구분자가 존재할 때, `//`와 `\n` 의 순서가 바뀌어도 정상적으로 추출되는지 확인한다.

### 4. **문자열 분리 및 숫자 변환**

- [x]  입력 문자열이 올바른 구분자로 분리되는지 확인한다.
- [X]  각 분리된 문자열이 숫자로 변환되는지 확인한다.
- [x]  음수 값이 입력된 경우 `IllegalArgumentException`이 발생하는지 확인한다.
- [x]  숫자가 아닌 값이 포함된 경우 `IllegalArgumentException`이 발생하는지 확인한다.
- **예상 엣지 케이스**:
    - [x]  "1,,2"와 같이 숫자 사이에 빈 값이 있을 때 0으로 처리되거나 예외가 발생하는지 확인한다.
    - [x]  매우 큰 숫자가 정상적으로 처리되는지 확인한다

### 5. **합계 계산**

- [x]  변환된 숫자의 합이 정확하게 계산되는지 확인한다.
- **예상 엣지 케이스**:
    - [x]  변환된 숫자의 크기가 매우 클 경우 적절한 예외처리를 확인한다

### 6. **결과 출력**

- [x]  "결과: (합계)" 형식으로 결과가 출력되는지 확인한다.