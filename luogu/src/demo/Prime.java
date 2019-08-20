package demo;

public class Prime {

	static int[] prime;
	static int totalPrimes = 0;

	public static void calculateNumber(int Nmax) {
		// 计算Nmax之内素数有多少个，并存到全局变量prime\totalPrimes中
		// 计算1亿之内的素数需要650ms，150M内存
		boolean[] isPrime = new boolean[Nmax + 1];
		prime = new int[Nmax / 10];
		totalPrimes = 1;
		for (int i = 3; i <= Nmax; i += 2)
			isPrime[i] = true;
		isPrime[2] = true;
		prime[0] = 2;
		for (int i = 3; i <= Nmax; i += 2) {
			if (isPrime[i])
				prime[totalPrimes++] = i;
			for (int j = 1; i * prime[j] <= Nmax && j < totalPrimes; j++) {
				isPrime[i * prime[j]] = false;
				if (i % prime[j] == 0)
					break;
			}
		}
	}

	public static void main(String[] args) {
		int Nmax = 100000000;
		double startTime = System.currentTimeMillis();
		calculateNumber(Nmax);
		double timeSpent = (System.currentTimeMillis() - startTime) / 1000;
		System.out.println("The prime numbers from 1 to " + Nmax + " is " + totalPrimes);
		System.out.println("Time spent : " + timeSpent + " s");
//		for (int i = 0; i < totalPrimes; i++) {
//			System.out.println(prime[i]);
//		}

	}
}
