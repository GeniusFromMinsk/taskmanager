package com.itacademy.courses;

import com.itacademy.courses.dao.TagDAO;
import com.itacademy.courses.models.Tag;
import com.itacademy.courses.services.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TagServiceTest {

    private TagDAO tagDAO;
    private TagService tagService;

    @BeforeEach
    public void setup() {
        tagDAO = Mockito.mock(TagDAO.class);
        tagService = new TagService(tagDAO);
    }

    @Test
    public void testCreate() {
        Tag tag = new Tag();
        tag.setName("Name");
        doNothing().when(tagDAO).insertTag(tag);
        tagService.addTag(tag);
        verify(tagDAO, times(1)).insertTag(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testUpdate() {
        Tag tag = new Tag();
        tag.setName("Name");
        doNothing().when(tagDAO).updateTag(tag);
        tagService.updateTag(tag);
        verify(tagDAO, times(1)).updateTag(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testGet() {
        Tag tag = new Tag();
        tag.setName("home");
        when(tagDAO.getTagById(13)).thenReturn(tag);
        Tag retrievedTag = tagService.getTagById(13);
        assertEquals("home", retrievedTag.getName());
    }

    @Test
    public void testDelete() {
        int id = 19;
        doNothing().when(tagDAO).deleteTag(id);
        when(tagDAO.getTagById(id)).thenReturn(null);
        tagService.deleteTag(id);
        verify(tagDAO, times(1)).deleteTag(id);
        assertNull(tagService.getTagById(id));
    }
}
