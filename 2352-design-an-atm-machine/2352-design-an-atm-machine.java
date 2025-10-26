class ATM {
    int[] bal = new int[5];
    int[] b = {20, 50, 100, 200, 500};

    public ATM() {}

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            bal[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] used = new int[5];
        int[] backup = bal.clone();

        for (int i = 4; i >= 0; i--) {
            int canUse = Math.min(bal[i], amount / b[i]);
            used[i] = canUse;
            bal[i] -= canUse;
            amount -= canUse * b[i];
        }

        if (amount == 0) return used; // success ✅

        // restore previous balances
        bal = backup;
        return new int[]{-1};
    }
}
