package org.example.service;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Zulfa Attar
 */
public class ListMock {

    @Test
    public void letsMockListSize(){

        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSize_WithMultipleValues(){

        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());

        System.out.println(listMock.size());
    }

    @Test
    public void letsMockListGet(){

        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("Zulfa");

        assertEquals("Zulfa", listMock.get(0));
        assertEquals("Zulfa", listMock.get(1));

    }

    @Test(expected = Exception.class)
    public void letsMockList_throwAnException(){

        List listMock = mock(List.class);
        when(listMock.get(anyInt())).
                thenThrow(new RuntimeException("Something has crashed"));

        listMock.get(0);
    }
}
