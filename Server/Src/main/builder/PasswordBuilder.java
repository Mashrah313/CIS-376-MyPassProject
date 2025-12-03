package builder;

import java.security.SecureRandom;

/**
 * PasswordBuilder implements the Builder pattern to construct strong passwords
 * with flexible options: length, include upper/lower letters, digits, symbols,
 * and ensure at least one character of each selected type is present.
 *
 * Usage:
 *   String pwd = new PasswordBuilder.Builder()
 *                   .length(16)
 *                   .useUpper(true)
 *                   .useLower(true)
 *                   .useDigits(true)
 *                   .useSymbols(true)
 *                   .build();
 *
 * This class uses SecureRandom to produce cryptographically strong random values.
 */
public final class PasswordBuilder {
    private final int length;
    private final boolean useUpper;
    private final boolean useLower;
    private final boolean useDigits;
    private final boolean useSymbols;
    private static final SecureRandom RANDOM = new SecureRandom();

    // Character sets
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%&*()-_=+[]{};:,.<>/?";

    private PasswordBuilder(Builder b) {
        this.length = b.length;
        this.useUpper = b.useUpper;
        this.useLower = b.useLower;
        this.useDigits = b.useDigits;
        this.useSymbols = b.useSymbols;
    }

    /**
     * Build a password according to the configured options.
     * This method ensures (if possible) that at least one character from
     * each selected category is included to meet complexity requirements.
     *
     * @return generated password string
     */
    public String build() {
        if (!useUpper && !useLower && !useDigits && !useSymbols) {
            throw new IllegalStateException("At least one character type must be selected.");
        }
        if (length < 4) {
            // length of 4 is still small but we allow 4+; you may raise this threshold
            throw new IllegalArgumentException("Password length must be >= 4.");
        }

        StringBuilder pool = new StringBuilder();
        // Ensure at least one char from each selected set
        StringBuilder guaranteed = new StringBuilder();

        if (useUpper) {
            pool.append(UPPER);
            guaranteed.append(randomCharFrom(UPPER));
        }
        if (useLower) {
            pool.append(LOWER);
            guaranteed.append(randomCharFrom(LOWER));
        }
        if (useDigits) {
            pool.append(DIGITS);
            guaranteed.append(randomCharFrom(DIGITS));
        }
        if (useSymbols) {
            pool.append(SYMBOLS);
            guaranteed.append(randomCharFrom(SYMBOLS));
        }

        // Fill remaining characters from pool
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length - guaranteed.length(); i++) {
            password.append(randomCharFrom(pool.toString()));
        }

        // Insert guaranteed characters at random positions
        char[] pwdArray = (password.toString() + guaranteed.toString()).toCharArray();
        // Shuffle array
        for (int i = pwdArray.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char tmp = pwdArray[i];
            pwdArray[i] = pwdArray[j];
            pwdArray[j] = tmp;
        }
        // If generated length is less than requested (possible if guaranteed > length),
        // we trim or expand safely (here we trim to length)
        String result = new String(pwdArray);
        if (result.length() > length) {
            result = result.substring(0, length);
        } else if (result.length() < length) {
            // pad with random chars from pool
            StringBuilder sb = new StringBuilder(result);
            while (sb.length() < length) sb.append(randomCharFrom(pool.toString()));
            result = sb.toString();
        }
        return result;
    }

    private static char randomCharFrom(String s) {
        int idx = RANDOM.nextInt(s.length());
        return s.charAt(idx);
    }

    /** Fluent builder for PasswordBuilder */
    public static class Builder {
        private int length = 12;
        private boolean useUpper = true;
        private boolean useLower = true;
        private boolean useDigits = true;
        private boolean useSymbols = false;

        public Builder() {}

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public Builder useUpper(boolean v) {
            this.useUpper = v;
            return this;
        }

        public Builder useLower(boolean v) {
            this.useLower = v;
            return this;
        }

        public Builder useDigits(boolean v) {
            this.useDigits = v;
            return this;
        }

        public Builder useSymbols(boolean v) {
            this.useSymbols = v;
            return this;
        }

        public PasswordBuilder buildBuilder() {
            return new PasswordBuilder(this);
        }

        /** Convenience: build password directly */
        public String build() {
            return this.buildBuilder().build();
        }
    }
}
