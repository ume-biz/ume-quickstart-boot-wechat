package org.umeframework.quickstart.sample.entity.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.umeframework.dora.bean.BeanValidator;
import org.umeframework.dora.transaction.TransactionRequired;
import org.umeframework.dora.service.BaseDBComponent;
import org.umeframework.quickstart.sample.entity.AlbumBasicDto;
import org.umeframework.quickstart.sample.entity.crud.AlbumBasicCrudService;

/**
 * 唱片基本信息:ALBUM_BASIC CRUD service implementation.<br>
 *
 * @author UME-Generator
 */
@org.springframework.stereotype.Service
public class AlbumBasicCrudServiceImpl extends BaseDBComponent implements AlbumBasicCrudService {

    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#create
     */
    @Override
    @TransactionRequired
    public Integer create(AlbumBasicDto entity) {
        validate(entity);
        if (entity.getCreateAuthor() == null) {
            entity.setCreateAuthor(super.getUid());
        }
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(super.getUid());
        }
        int result = super.getDao().update(AlbumBasicDto.SQLID.INSERT, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#createList
     */
    @Override
    @TransactionRequired
    public List<Integer> createList(List<AlbumBasicDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumBasicDto entity : entityList) {
            result.add(this.create(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#createOrUpdate
     */
    @Override
    @TransactionRequired
    public Integer createOrUpdate(AlbumBasicDto entity) {
        AlbumBasicDto existed = super.getDao().queryForObject(AlbumBasicDto.SQLID.FIND, entity, AlbumBasicDto.class);
        if (existed == null) {
            return this.create(entity);
        } else {
            validate(entity);
            return this.update(entity);
        }
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#createOrUpdateList
     */
    @Override
    @TransactionRequired
    public List<Integer> createOrUpdateList(List<AlbumBasicDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumBasicDto entity : entityList) {
            result.add(this.createOrUpdate(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#update
     */
    @Override
    @TransactionRequired
    public Integer update(AlbumBasicDto entity) {
        validate(entity);
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(super.getUid());
        }
        int result = super.getDao().update(AlbumBasicDto.SQLID.SMART_UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#updateList
     */
    @Override
    @TransactionRequired
    public List<Integer> updateList(List<AlbumBasicDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumBasicDto entity : entityList) {
            result.add(this.update(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#updateFully
     */
    @Override
    @TransactionRequired
    public Integer updateFully(AlbumBasicDto entity) {
        validate(entity);
        int result = super.getDao().update(AlbumBasicDto.SQLID.UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#updateFullyList
     */
    @Override
    @TransactionRequired
    public List<Integer> updateFullyList(List<AlbumBasicDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumBasicDto entity : entityList) {
            result.add(this.updateFully(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#delete
     */
    @Override
    @TransactionRequired
    public Integer delete(AlbumBasicDto entity) {
        int result = super.getDao().update(AlbumBasicDto.SQLID.DELETE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#deleteList
     */
    @Override
    @TransactionRequired
    public List<Integer> deleteList(List<AlbumBasicDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumBasicDto entity : entityList) {
            result.add(this.delete(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#find
     */
    @Override
    public AlbumBasicDto find(AlbumBasicDto queryParam) {
        return super.getDao().queryForObject(AlbumBasicDto.SQLID.FIND, queryParam, AlbumBasicDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#findList
     */
    @Override
    public List<AlbumBasicDto> findList(AlbumBasicDto condition) {
        return super.getDao().queryForObjectList(AlbumBasicDto.SQLID.FIND_LIST, condition, AlbumBasicDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#findListLike
     */
    @Override
    public List<AlbumBasicDto> findListLike(Map<String, String> condition) {
        return super.getDao().queryForObjectList(AlbumBasicDto.SQLID.FIND_LIST_LIKE, condition, AlbumBasicDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService#findListMatch
     */
    @Override
    public List<AlbumBasicDto> findListMatch(Map<String, String> dynaCondition) {
        return super.getDao().queryForObjectList(AlbumBasicDto.SQLID.FIND_LIST_MATCH, dynaCondition, AlbumBasicDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumBasicCrudService
     */
    @Override
    public Integer count(Map<String, String> condition) {
        return super.getDao().count(AlbumBasicDto.SQLID.COUNT, condition);
    }

    /**
     * Do entity validation before doUpdate
     * 
     * @param entity - Target doUpdate Entity
     */
    protected void validate(AlbumBasicDto entity) {
        // Here invoke the default entity check logic
        BeanValidator beanValidator = new BeanValidator();
        // Invoke validation rule
        beanValidator.validate(entity);
    }
}
