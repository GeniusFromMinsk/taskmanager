package com.itclopedia.courses;

import com.itclopedia.courses.models.Tag;
import com.itclopedia.courses.dao.TagRepository;
import com.itclopedia.courses.services.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TagServiceTest {

    /*private TagRepository tagRepository;
    private TagService tagService;

    @BeforeEach
    public void setup() {
        tagRepository = Mockito.mock(TagRepository.class);
        tagService = new TagService(tagRepository);
    }

    @Test
    public void testCreate() {
        Tag tag = new Tag();
        tag.setName("Name");
        when(tagRepository.save(tag)).thenReturn(tag);

        tagService.addTag(tag);

        verify(tagRepository, times(1)).save(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testUpdate() {
        Tag tag = new Tag();
        tag.setName("Name");
        when(tagRepository.save(tag)).thenReturn(tag);

        tagService.updateTag(tag);

        verify(tagRepository, times(1)).save(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testGet() {
        Tag tag = new Tag();
        tag.setName("home");

        when(tagRepository.findById(13)).thenReturn(Optional.of(tag));

        Tag retrievedTag = tagService.getTagById(13);
        assertEquals("home", retrievedTag.getName());
    }

    @Test
    public void testDelete() {
        int id = 19;

        when(tagRepository.existsById(id)).thenReturn(true);
        doNothing().when(tagRepository).deleteById(id);

        tagService.deleteTag(id);

        verify(tagRepository, times(1)).deleteById(id);
        when(tagRepository.findById(id)).thenReturn(Optional.empty());
        Tag deletedTag = tagService.getTagById(id);
        assertNull(deletedTag);
    }

     */
}
