package lotto3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

  private static final int LOTTO_NUMBERS_SIZE = 6;

  private final List<LottoNumber> winningNumbers;

  public WinningNumbers(List<Integer> winningNumbers) {
    validateHasSixNumbers(winningNumbers);
    validateDuplicate(winningNumbers);
    this.winningNumbers = convertToLottoNumbers(winningNumbers);
  }

  private void validateDuplicate(List<Integer> winningNumbers) {
    if (hasDuplicate(winningNumbers)) {
      throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
    }
  }

  private boolean hasDuplicate(List<Integer> winningNumbers) {
    return winningNumbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE;
  }

  private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
    return numbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }



  private void validateHasSixNumbers(List<Integer> winningNumbers) {
    if (!hasSixNumbers(winningNumbers)) {
      throw new IllegalArgumentException("지난 주 당첨 번호는 6개를 입력해 주세요.");
    }
  }

  private boolean hasSixNumbers(List<Integer> winningNumbers) {
    return winningNumbers.size() == LOTTO_NUMBERS_SIZE;
  }



  public boolean contains(LottoNumber lottoNumber) {
    return winningNumbers.stream()
        .anyMatch(number -> number.equals(lottoNumber));
  }

  public void validateHasDuplicateNumber(LottoNumber bonusNumber) {
    if (contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
