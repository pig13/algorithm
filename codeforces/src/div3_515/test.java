package div3_515;

public class test {
	public static void main(String[] args) {
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		System.out.println(Float.SIZE);
		System.out.println(Float.BYTES);
		System.out.println(Long.SIZE);
		System.out.println(Long.BYTES);
		System.out.println(Double.SIZE);
		System.out.println(Double.BYTES);

	}

	public static long fastPow(long a, long b) {
		long MOD = 999999999; // TODO 用的时候记得改
		long ans = 1;
		long base = a;
		for (; b != 0;) {
			if ((b & 1) == 1) {
				ans = (ans * base) % MOD;
			}
			base = (base % MOD) * (base % MOD) % MOD;
			b = b >> 1;
		}
		return ans;
	}

	public static long fastMul(long a, long b, long mod) {
		// log n 时间复杂度 慢
		long sum = 0;
		long k = 1;
		for (; b != 0;) {
			if ((b & 1) == 1) {
				sum = (sum + a * k) % mod;
			}
			k = (k * 2) % mod;
			b = b / 2;
		}
		return sum;
	}

	public static long fastMul2(long a, long b, long mod) {
		// O(1) 但是是mod大于 Long.MAX_VALUE**0.5 会爆掉
		a %= mod;
		b %= mod;
		return (a * b - (long) (((double) a * b + 0.5) / mod) * mod) % mod;
	}

	public static long fastMul3(long a, long b, long mod) {
		// O(1) 但是是mod大于 Long.MAX_VALUE 会爆掉
		long lf = a * (b >> (long) 25) % mod * ((long) 1 << 25) % mod;
		long rg = a * (b & (((long) 1 << 25) - 1)) % mod;
		return (lf + rg) % mod;

	}

}
