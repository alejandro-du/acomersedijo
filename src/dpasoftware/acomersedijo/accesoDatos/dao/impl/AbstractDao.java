package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import dpasoftware.acomersedijo.accesoDatos.dao.IAbstractDao;

public abstract class AbstractDao<T> implements IAbstractDao<T> {
    
    private EntityManagerFactory entityManagerFactory;

    @SuppressWarnings("unchecked")
	public List<T> executeSelect(Query query, Object params[]) {

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }

        List<T> list = null;

        try {
            list = query.getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
            list.clear();
        }

        return list;
    }

    @SuppressWarnings("unchecked")
	public T executeSingleResultSelect(Query query, Object params[]) {

        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }

        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<T> executeLimitedSelect(String query, int limit) {
        Query q = getEntityManager().createQuery(query);
        q.setMaxResults(limit);
        return executeSelect(q, null);
    }

    public List<T> executeLimitedSelect(String query, Object params[], int limit) {
        Query q = getEntityManager().createQuery(query);
        q.setMaxResults(limit);
        return executeSelect(q, params);
    }

    public List<T> executeSelect(String query) {
        return executeSelect(query, null);
    }

    public List<T> executeSelect(String query, Object params[]) {
        Query q = getEntityManager().createQuery(query);
        return executeSelect(q, params);
    }

    public T executeSingleResultSelect(String query, Object params[]) {
        Query q = getEntityManager().createQuery(query);
        return executeSingleResultSelect(q, params);
    }

    public void ejecutarUpdate(Query query) {

        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

            if (transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            entityManager.close();
        }
    }

    /**
     * Usa java reflection para obtener el nombre del tipo parámetro T.
     * @return Nombre de la clase correspondiente a T.
     */
    @SuppressWarnings("unchecked")
	public String getNombreT() {

        Type type = getClass().getGenericSuperclass();
        T vo = null;

        if (type instanceof ParameterizedType) {
            try {
                ParameterizedType paramType = (ParameterizedType) type;
                Class<T> tClass = (Class<T>) paramType.getActualTypeArguments()[0];

                vo = tClass.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vo.getClass().getSimpleName();
    }

    public List<T> listarTodos() {

        Query query = getEntityManager().createQuery("SELECT vo FROM " + getNombreT() + " vo");
        return (List<T>) executeSelect(query, null);
    }

    public T obtenerPorId(Long id) {
        Query query = getEntityManager().createQuery("SELECT vo FROM " + getNombreT() + " vo WHERE vo.id = :id");
        query.setParameter("id", id);

        List<T> lista = executeSelect(query, null);

        if (lista == null || lista.size() <= 0) {
            return null;
        }

        return lista.get(0);
    }

    public boolean guardarOActualizarPorId(Object vo) {

        if (vo == null) {
            return false;
        }

        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(em.merge(vo));
            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

            if (transaction.isActive()) {
                transaction.rollback();
            }

            return false;

        } finally {
            em.close();
        }

        return true;
    }

    public boolean eliminarPorId(Long id) {

        if (obtenerPorId(id) == null) {
            return false;
        }

        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Query query = em.createQuery("DELETE FROM " + getNombreT() + " vo WHERE vo.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();

            if (transaction.isActive()) {
                transaction.rollback();
            }

            return false;

        } finally {
            em.close();
        }
        return true;
    }

    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

}
