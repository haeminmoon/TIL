서광열 /
에릿 엘리엇

- 프로그래밍이란, 큰 문제를 작은 것으로 쪼개서 그것들을 조합하여 해결하고 이를 (합성)활용하여 큰 문제를 푸는 것이다.

함수합성 (function composition) / 객체합성 (object composition)


무조건 작은 문제로 나누어서, 복잡한 문제를 해결하자.


promise 객체? 무조건 비동기로 실행하는 객체

const add10 = a => new Promise(resolve => resolve(a + 10));
const sub10 = a => a - 10;
const add 5 = a => a + 5;
const add10 = a => new Promise(resolve => resolve(a - 5));


// f1 :: a -> b
async function f1(a) {
  var b;
  return b;
}

항상 비동기를 고려하자.
