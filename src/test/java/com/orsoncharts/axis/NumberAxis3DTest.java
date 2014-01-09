/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of this source file is prohibited.
 * 
 */

package com.orsoncharts.axis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import com.orsoncharts.Range;
import com.orsoncharts.TestUtils;
import java.text.DecimalFormat;

/**
 * Checks for the {@link NumberAxis3D} class.
 */
public class NumberAxis3DTest implements Axis3DChangeListener {
    
    @Test
    public void checkSetVisibleFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setVisible(false);
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }

    @Test
    public void checkSetLabelFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setLabel("XXX");
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }
  
    @Test
    public void checkSetLabelFontFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setLabelFont(new Font("Dialog", Font.BOLD, 7));
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }
  
    @Test
    public void checkSetLineStrokeFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setLineStroke(new BasicStroke(1.0f));
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }
   
    @Test
    public void checkSetLineColorFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setLineColor(Color.RED);
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }
  
    @Test
    public void checkSetRangeFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setRange(new Range(1, 2));
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }

    @Test
    public void checkSetTickSizeFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setTickSize(5.0);
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }  

    @Test
    public void checkSetTickLabelFontFiresChangeEvent() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        axis1.addChangeListener(this);
        assertNull(this.lastEvent);
    
        axis1.setTickLabelFont(new Font("Dialog", Font.PLAIN, 11));
        assertNotNull(this.lastEvent);
        this.lastEvent = null;
    }  

    @Test
    public void checkEquals() {
        NumberAxis3D axis1 = new NumberAxis3D("X");
        NumberAxis3D axis2 = new NumberAxis3D("X");
        assertTrue(axis1.equals(axis2));
    
        axis1.setLabel("ZZZ");
        assertNotEquals(axis1, axis2);
        axis2.setLabel("ZZZ");
        assertEquals(axis1, axis2);
    
        axis1.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        assertNotEquals(axis1, axis2);
        axis2.setLabelFont(new Font("Dialog", Font.PLAIN, 8));
        assertEquals(axis1, axis2);
    
        axis1.setLineStroke(new BasicStroke(2.0f));
        assertNotEquals(axis1, axis2);
        axis2.setLineStroke(new BasicStroke(2.0f));
        assertEquals(axis1, axis2);

        axis1.setLineColor(Color.RED);
        assertNotEquals(axis1, axis2);
        axis2.setLineColor(Color.RED);
        assertEquals(axis1, axis2);
    
        axis1.setRange(new Range(1, 2));
        assertNotEquals(axis1, axis2);
        axis2.setRange(new Range(1, 2));
        assertEquals(axis1, axis2);

        axis1.setAutoAdjustRange(true);
        assertFalse(axis1.equals(axis2));
        axis2.setAutoAdjustRange(true);
        assertTrue(axis1.equals(axis2));

        axis1.setLowerMargin(0.123);
        assertFalse(axis1.equals(axis2));
        axis2.setLowerMargin(0.123);
        assertTrue(axis1.equals(axis2));
        
        axis1.setUpperMargin(0.123);
        assertFalse(axis1.equals(axis2));
        axis2.setUpperMargin(0.123);
        assertTrue(axis1.equals(axis2));

        axis1.setAutoRangeIncludeZero(true);
        assertFalse(axis1.equals(axis2));
        axis2.setAutoRangeIncludeZero(true);
        assertTrue(axis1.equals(axis2));
        
        axis1.setAutoRangeStickyZero(false);
        assertFalse(axis1.equals(axis2));
        axis2.setAutoRangeStickyZero(false);
        assertTrue(axis1.equals(axis2));
        
        axis1.setDefaultAutoRange(new Range(5, 10));
        assertFalse(axis1.equals(axis2));
        axis2.setDefaultAutoRange(new Range(5, 10));
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickSelector(new NumberTickSelector(true));
        assertFalse(axis1.equals(axis2));
        axis2.setTickSelector(new NumberTickSelector(true));
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickSelector(null);
        assertFalse(axis1.equals(axis2));
        axis2.setTickSelector(null);
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickSize(1.23);
        assertNotEquals(axis1, axis2);
        axis2.setTickSize(1.23);
        assertEquals(axis1, axis2);
    
        axis1.setTickLabelFormatter(new DecimalFormat("0.0000"));
        assertFalse(axis1.equals(axis2));
        axis2.setTickLabelFormatter(new DecimalFormat("0.0000"));
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickLabelFactor(1.23);
        assertFalse(axis1.equals(axis2));
        axis2.setTickLabelFactor(1.23);
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickLabelFont(new Font("Dialog", Font.BOLD, 20));
        assertNotEquals(axis1, axis2);
        axis2.setTickLabelFont(new Font("Dialog", Font.BOLD, 20));
        assertEquals(axis1, axis2);

        axis1.setTickLabelOffset(2.2);
        assertFalse(axis1.equals(axis2));
        axis2.setTickLabelOffset(2.2);
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickMarkLength(1.21);
        assertFalse(axis1.equals(axis2));
        axis2.setTickMarkLength(1.21);
        assertTrue(axis1.equals(axis2));

        axis1.setTickMarkPaint(Color.RED);
        assertFalse(axis1.equals(axis2));
        axis2.setTickMarkPaint(Color.RED);
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickMarkStroke(new BasicStroke(2f));
        assertFalse(axis1.equals(axis2));
        axis2.setTickMarkStroke(new BasicStroke(2f));
        assertTrue(axis1.equals(axis2));
        
        axis1.setVisible(false);
        assertNotEquals(axis1, axis2);
        axis2.setVisible(false);
        assertEquals(axis1, axis2);
        
    }
  
    /**
     * Checks for serialization support.
     */
    @Test
    public void testSerialization() {
        NumberAxis3D axis1 = new NumberAxis3D("T");
        NumberAxis3D axis2 = (NumberAxis3D) TestUtils.serialized(axis1);
        assertTrue(axis1.equals(axis2));
        
        axis1.setLabelPaint(new GradientPaint(1f, 2f, Color.RED, 3f, 4f, 
                Color.BLUE));
        axis2 = (NumberAxis3D) TestUtils.serialized(axis1);
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickMarkPaint(new GradientPaint(5f, 6f, Color.GREEN, 7f, 8f,
                Color.YELLOW));
        axis2 = (NumberAxis3D) TestUtils.serialized(axis1);
        assertTrue(axis1.equals(axis2));
        
        axis1.setTickMarkPaint(new GradientPaint(9f, 10f, Color.PINK, 11f, 12f,
                Color.BLACK));
        axis2 = (NumberAxis3D) TestUtils.serialized(axis1);
        assertTrue(axis1.equals(axis2));
    }
    
    
    private Axis3DChangeEvent lastEvent;

    @Override
    public void axisChanged(Axis3DChangeEvent event) {
        this.lastEvent = event;
    }

}
