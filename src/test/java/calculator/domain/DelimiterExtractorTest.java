package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.INVALID_VALUE_FORMAT;
import static calculator.domain.constant.errorMessage.ValueError.MULTIPLE_CHARACTER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor extractor = new DelimiterExtractor();

    @Test
    @DisplayName("커스텀 구분자가 있을 때 올바르게 구분자를 추출한다")
    void extractCustomDelimiterCorrectly() {
        String input = "//;\\n1;2;3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\\n");

        assertEquals(",|:|\\Q;\\E", result);
    }

    @Test
    @DisplayName("기본 구분자만 있을 때 기본 구분자를 반환한다")
    void extractDefaultDelimiters() {
        String input = "1,2:3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\n");

        assertEquals(",|:", result);
    }

    @Test
    @DisplayName("커스텀 구분자가 역순으로 있을 때 구분자를 올바르게 추출한다")
    void extractReversedCustomDelimiter() {
        String input = "\\n;//1;2;3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\\n");

        assertEquals(",|:|\\Q;\\E", result);  // 커스텀 구분자가 없으면 기본 구분자만 포함
    }

    @Test
    @DisplayName("구분자가 없을 때 기본 구분자를 반환한다")
    void noDelimitersReturnsDefaultDelimiters() {
        String input = "123";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\n");

        assertEquals(",|:", result);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러 문자일 때 예외반환")
    void extractMultiCharacterCustomDelimiter() {
        String input = "//[***]\\n1***2***3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.extractDelimiters(input, ",|:", "//", "\\n"));
        assertEquals(MULTIPLE_CHARACTER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("-를 커스텀 구분자로 반환")
    void extractMinusDelimiterCorrectly() {
        String input = "//-\\n1;2;3";
        String result = extractor.extractDelimiters(input, ",|:", "//", "\\n");

        assertEquals(",|:|\\Q-\\E", result);
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 입력되면 예외가 발생한다")
    void throwsExceptionForNonNumericInput() {
        Parser parser = new Parser();
        String input = "1,a,3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> parser.parseInput(input));
        assertEquals(INVALID_VALUE_FORMAT.getMessage(), exception.getMessage());
    }

}
