package com.app.debugger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void initMocks() {
        mCalculator=new Calculator();
    }

    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 2d);
        assertThat(resultAdd,is(equalTo(3d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd,is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222d,0.01)));
    }

    @Test
    public void subTwoNumbers()
    {
        double resultSub = mCalculator.sub(3d, 2d);
        assertThat(resultSub,is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResults()
    {
        double resultSub = mCalculator.sub(3d, 5d);
        assertThat(resultSub,is(equalTo(-2d)));
    }

    @Test
    public void mulTwoNumbers()
    {
        double resultMul = mCalculator.mul(3d, 5d);
        assertThat(resultMul,is(equalTo(15d)));
    }

    @Test
    public void mulTwoNumbersZero()
    {
        double resultMul = mCalculator.mul(3d, 0d);
        assertThat(resultMul,is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers()
    {
        double resultDiv = mCalculator.div(15d, 5d);
        assertThat(resultDiv,is(equalTo(3d)));
    }
    @Test
    public void divTwoNumbersZero()
    {
        double resultDiv = mCalculator.div(15d, 0d);
        assertThat(resultDiv,is(equalTo(Double.POSITIVE_INFINITY)));
    }

}
