package ru.petrovich.code.practice;

import lombok.SneakyThrows;

import java.math.BigInteger;

public class ComplexCalculation {
    @SneakyThrows
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        PowerCalculatingThread left = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread right = new PowerCalculatingThread(base2, power2);

        left.start();
        right.start();
        left.join();
        right.join();

        result = left.result.add(right.result);
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = base.pow(power.intValue());
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
