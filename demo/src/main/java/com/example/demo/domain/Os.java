package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An operating system (OS) like Windows, Android, Linux.
 * <p>
 * Avoid lombok annotations like EqualsAndHashCode on entity classes:
 * <p>
 * <a href="https://www.jpa-buddy.com/blog/lombok-and-jpa-what-may-go-wrong/">lombok-and-jpa-what-may-go-wrong</a>
 * <p>
 * <a href=
 * "https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/">lombok-hibernate-how-to-avoid-common-pitfalls</a>
 */
@Getter
@Setter
@Entity
@Table(name = "os")
public class Os {

	@Id
	@Column(nullable = false, columnDefinition = "tinyint(4) NOT NULL")
	private Integer id;
	@Column(unique = true)
	private String name;
	@Column(name = "option_id", nullable = false, columnDefinition = "tinyint(4) NOT NULL DEFAULT '6'")
	private Integer optionId = 6;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Os)) {
			return false;
		}
		return id != null && id.equals(((Os) o).id);
	}

	@Override
	public int hashCode() {
		// see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "Os{" + "id=" + id + ", name='" + name + '\'' + ", optionId=" + optionId + '}';
	}
}
