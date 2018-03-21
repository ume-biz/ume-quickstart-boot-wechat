package org.umeframework.quickstart.sample.entity.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.umeframework.dora.bean.BeanValidator;
import org.umeframework.dora.transaction.TransactionRequired;
import org.umeframework.dora.service.BaseDBComponent;
import org.umeframework.quickstart.sample.entity.AlbumContributorDto;
import org.umeframework.quickstart.sample.entity.crud.AlbumContributorCrudService;

/**
 * 唱片参与表演者:ALBUM_CONTRIBUTOR CRUD service implementation.<br>
 *
 * @author UME-Generator
 */
@org.springframework.stereotype.Service
public class AlbumContributorCrudServiceImpl extends BaseDBComponent implements AlbumContributorCrudService {

    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#create
     */
    @Override
    @TransactionRequired
    public Integer create(AlbumContributorDto entity) {
        validate(entity);
        if (entity.getCreateAuthor() == null) {
            entity.setCreateAuthor(super.getUid());
        }
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(super.getUid());
        }
        int result = super.getDao().update(AlbumContributorDto.SQLID.INSERT, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#createList
     */
    @Override
    @TransactionRequired
    public List<Integer> createList(List<AlbumContributorDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumContributorDto entity : entityList) {
            result.add(this.create(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#createOrUpdate
     */
    @Override
    @TransactionRequired
    public Integer createOrUpdate(AlbumContributorDto entity) {
        AlbumContributorDto existed = super.getDao().queryForObject(AlbumContributorDto.SQLID.FIND, entity, AlbumContributorDto.class);
        if (existed == null) {
            return this.create(entity);
        } else {
            validate(entity);
            return this.update(entity);
        }
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#createOrUpdateList
     */
    @Override
    @TransactionRequired
    public List<Integer> createOrUpdateList(List<AlbumContributorDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumContributorDto entity : entityList) {
            result.add(this.createOrUpdate(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#update
     */
    @Override
    @TransactionRequired
    public Integer update(AlbumContributorDto entity) {
        validate(entity);
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(super.getUid());
        }
        int result = super.getDao().update(AlbumContributorDto.SQLID.SMART_UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#updateList
     */
    @Override
    @TransactionRequired
    public List<Integer> updateList(List<AlbumContributorDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumContributorDto entity : entityList) {
            result.add(this.update(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#updateFully
     */
    @Override
    @TransactionRequired
    public Integer updateFully(AlbumContributorDto entity) {
        validate(entity);
        int result = super.getDao().update(AlbumContributorDto.SQLID.UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#updateFullyList
     */
    @Override
    @TransactionRequired
    public List<Integer> updateFullyList(List<AlbumContributorDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumContributorDto entity : entityList) {
            result.add(this.updateFully(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#delete
     */
    @Override
    @TransactionRequired
    public Integer delete(AlbumContributorDto entity) {
        int result = super.getDao().update(AlbumContributorDto.SQLID.DELETE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#deleteList
     */
    @Override
    @TransactionRequired
    public List<Integer> deleteList(List<AlbumContributorDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumContributorDto entity : entityList) {
            result.add(this.delete(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#find
     */
    @Override
    public AlbumContributorDto find(AlbumContributorDto queryParam) {
        return super.getDao().queryForObject(AlbumContributorDto.SQLID.FIND, queryParam, AlbumContributorDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#findList
     */
    @Override
    public List<AlbumContributorDto> findList(AlbumContributorDto condition) {
        return super.getDao().queryForObjectList(AlbumContributorDto.SQLID.FIND_LIST, condition, AlbumContributorDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#findListLike
     */
    @Override
    public List<AlbumContributorDto> findListLike(Map<String, String> condition) {
        return super.getDao().queryForObjectList(AlbumContributorDto.SQLID.FIND_LIST_LIKE, condition, AlbumContributorDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService#findListMatch
     */
    @Override
    public List<AlbumContributorDto> findListMatch(Map<String, String> dynaCondition) {
        return super.getDao().queryForObjectList(AlbumContributorDto.SQLID.FIND_LIST_MATCH, dynaCondition, AlbumContributorDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumContributorCrudService
     */
    @Override
    public Integer count(Map<String, String> condition) {
        return super.getDao().count(AlbumContributorDto.SQLID.COUNT, condition);
    }

    /**
     * Do entity validation before doUpdate
     * 
     * @param entity - Target doUpdate Entity
     */
    protected void validate(AlbumContributorDto entity) {
        // Here invoke the default entity check logic
        BeanValidator beanValidator = new BeanValidator();
        // Invoke validation rule
        beanValidator.validate(entity);
    }
}
