package CodeChefContest.practice;

/**
 * PROBLEM:
 * Chef has two numbers NN and MM. He calls a pair of numbers (A, B)(A,B) good if it satisfies the following conditions:
 *
 * 1 \le A, B \le M1≤A,B≤M
 * \gcd(A, B) \ge Ngcd(A,B)≥N
 * Chef wants to find a good pair (A, B)(A,B) such that the value of |A - B|∣A−B∣ is maximized. Can you help Chef? (Here |X|∣X∣ represents the absolute value of XX).
 *
 * If there are multiple good pairs for which the value of |A - B|∣A−B∣ is maximized, you can print any of them. It can be proved that under the given constraints, at least one good pair always exists.
 *
 * EXPLANATION:
 * WLOG, Let us assume A\leq BA≤B for the further discussion.
 * Observation 1: Let g\geq Ng≥N be the GCDGCD of AA and BB in the optimal answer then A=gA=g as if A \gt gA>g we can make A=gA=g as it will further improve the answer and still satisfy the constraints of the problem. Similarly choose B=M-MB=M−M%gg the greatest multiple of g(\leq M)g(≤M) by same reasoning.
 * Observation 2: Let g\geq Ng≥N be the GCDGCD of AA and BB in the optimal answer. Then g \lt 2\cdot Ng<2⋅N. If M \lt 2\cdot NM<2⋅N then there are no two distinct multiples of any number between NN to MM that are both less than MM and the maximum possible answer is this case is 00. Now M\geq2\cdot NM≥2⋅N Suppose g\geq2\cdot Ng≥2⋅N, Then the maximum possible answer with this value of gg is M-2\cdot NM−2⋅N (maximum value of BB is MM and minimum value of AA is gg). The minimum value if we choose A(A( or g)g) as NN is (M-M(M−M%N)-N\leq M-2*N-1N)−N≤M−2∗N−1. Therefore g \lt 2\cdot Ng<2⋅N
 *
 * Thus from these observations we have the solution as: if M \lt 2\cdot NM<2⋅N the maximum value of |A - B|∣A−B∣ is zero hence print any number twice between NN and MM. Otherwise iterate on the value of gg from NN till 2\cdot N-12⋅N−1 choosing AA as gg and BB as M-MM−M%gg and choose the values of AA and BB such that the value of |A - B|∣A−B∣ is maximized.
 *
 * TIME COMPLEXITY:
 * O(N)O(N) for each test case.
 */
public class Problem1 {
    public static void main(String[] args) {

    }

    void ans(){
//        int n, m;
//        cin >> n >> m;
//        if (m < 2 * n)
//        {
//            cout << m << ' ' << m << '\n';
//            return;
//        }
//        int mx = 0, a = m, b = m;
//        for (int i = n; i < 2 * n; i++)
//        {
//            if (((m / i) * i) - i > mx)
//                a = i, b = (m / i) * i, mx = ((m / i) * i) - i;
//        }
//        cout << a << ' ' << b << '\n';
//        return;

    }
}
