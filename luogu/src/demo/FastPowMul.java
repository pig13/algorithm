package demo;

public class FastPowMul {

	public static long fastPow(long a, long b, long MOD) {
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
		// mod < Long.MAX_VALUE
		// a*b < long.MAX
		long lf = a * (b >> (long) 25) % mod * ((long) 1 << 25) % mod;
		long rg = a * (b & (((long) 1 << 25) - 1)) % mod;
		return (lf + rg) % mod;

	}

}
